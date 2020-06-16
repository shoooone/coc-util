package com.shooone.cocapiproxy.infrastructure

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@ConfigurationProperties("app.aws.settings")
@Configuration
class AWSSettings {
    lateinit var bucket: String
    lateinit var dynamo: String
}
