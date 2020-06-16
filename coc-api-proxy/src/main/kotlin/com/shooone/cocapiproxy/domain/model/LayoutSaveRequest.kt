package com.shooone.cocapiproxy.domain.model

import org.springframework.web.multipart.MultipartFile

data class LayoutSaveRequest(
        val url: String,
        val level: String,
        val type: String,
        val comment: String?,
        val file: MultipartFile
)
