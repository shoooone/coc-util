package com.shooone.cocapiproxy

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.ResponseEntity
import org.springframework.http.server.RequestPath
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping
class ProxyController(val restTemplate: RestTemplate) {

    @CrossOrigin("*")
    @GetMapping("**")
    fun proxy(req: HttpServletRequest): ResponseEntity<String?> {
        val res = restTemplate.getForEntity<String>("""https://api.clashofclans.com/v1${req.requestURI}?${req.queryString}""")
        return ResponseEntity.status(res.statusCode).body(res.body)
    }
}
