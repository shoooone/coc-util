package com.shooone.cocapiproxy.config

import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpRequest
import org.springframework.http.client.*
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.DefaultUriBuilderFactory
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.Charset

@Configuration
class AppConfig {
    @Value("\${api.key}")
    private val apiKey = ""

    @Bean
    fun restTemplate(): RestTemplate {
        val uriBuilder = DefaultUriBuilderFactory()
        uriBuilder.encodingMode = DefaultUriBuilderFactory.EncodingMode.NONE
        val restTemplate = RestTemplateBuilder()
                .requestFactory { BufferingClientHttpRequestFactory(SimpleClientHttpRequestFactory()) }
                .uriTemplateHandler(uriBuilder)
                .defaultHeader("Authorization", """Bearer $apiKey""")
                .build()
        restTemplate.interceptors = listOf(LoggingRequestInterceptor())
        return restTemplate

    }

    @Bean
    fun amazonS3() = AmazonS3ClientBuilder.standard().build()

    @Bean
    fun dynamoDb() = DynamoDbEnhancedClient.builder().dynamoDbClient(DynamoDbClient.create()).build()

}

class LoggingRequestInterceptor : ClientHttpRequestInterceptor {
    @Throws(IOException::class)
    override fun intercept(request: HttpRequest, body: ByteArray, execution: ClientHttpRequestExecution): ClientHttpResponse {
        traceRequest(request, body)
        val response = execution.execute(request, body)
        traceResponse(response)
        return response
    }

    /**
     * リクエストのログ出力.
     *
     * @param request HttpRequest
     * @param body リクエスト
     * @throws IOException 例外発生時
     */
    @Throws(IOException::class)
    private fun traceRequest(request: HttpRequest, body: ByteArray) {
        println("URI         : {${request.uri}}")
        println("Method      : {${request.method}}")
        println("Headers     : {${request.headers}}")
        println("Request body: {${String(body, Charset.defaultCharset())}}")
    }

    /**
     * レスポンスのログ出力.
     *
     * @param response ClientHttpResponse
     * @throws IOException 例外発生時
     */
    @Throws(IOException::class)
    private fun traceResponse(response: ClientHttpResponse) {
        val inputStringBuilder = StringBuilder()
        val bufferedReader = BufferedReader(InputStreamReader(response.body, "UTF-8"))
        var line: String? = bufferedReader.readLine()
        while (line != null) {
            inputStringBuilder.append(line)
            inputStringBuilder.append('\n')
            line = bufferedReader.readLine()
        }
        println("Status code  : {${response.statusCode}}")
        println("Status text  : {${response.statusText}}")
        println("Headers      : {${response.headers}}")
        println("Response body: {${inputStringBuilder}}")
    }


}
