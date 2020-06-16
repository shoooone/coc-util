package com.shooone.cocapiproxy.controller

import org.springframework.http.ResponseEntity
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
    @GetMapping("clans*", "clanwarleagues*", "players*", "leagues*", "warleagues*", "locations*", "labels*")
    fun proxy(req: HttpServletRequest): ResponseEntity<String?> {
        if (req.requestURI == null) return ResponseEntity.ok("")
        val res = restTemplate.getForEntity<String>("""https://api.clashofclans.com/v1${req.requestURI}?${req.queryString}""")
        return ResponseEntity.status(res.statusCode).body(res.body)
    }
}
