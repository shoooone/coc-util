package com.shooone.cocapiproxy.controller

import com.shooone.cocapiproxy.domain.model.LayoutSaveRequest
import com.shooone.cocapiproxy.domain.service.LayoutService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("layouts")
class LayoutsController(val service: LayoutService) {

    @PostMapping
    fun save(@RequestBody request: LayoutSaveRequest) {
        service.saveLayouts(request)
    }
}
