package com.shooone.cocapiproxy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CocApiProxyApplication

fun main(args: Array<String>) {
	runApplication<CocApiProxyApplication>(*args)
}
