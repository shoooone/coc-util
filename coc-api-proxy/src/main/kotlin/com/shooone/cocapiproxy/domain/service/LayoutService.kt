package com.shooone.cocapiproxy.domain.service

import com.shooone.cocapiproxy.domain.model.LayoutInfo
import com.shooone.cocapiproxy.domain.model.LayoutSaveRequest
import com.shooone.cocapiproxy.domain.repository.ImageRepository
import com.shooone.cocapiproxy.domain.repository.LayoutRepository
import org.springframework.stereotype.Service
import org.springframework.web.util.UriComponentsBuilder

@Service
class LayoutService(val imageRepo: ImageRepository,
                    val layoutRepo: LayoutRepository) {

    fun saveLayouts(req: LayoutSaveRequest) {
        val uriComponents = UriComponentsBuilder.fromHttpUrl(req.url).build()
        val id = uriComponents.queryParams["id"]?.first() ?: throw IllegalArgumentException()
        val info = LayoutInfo()
        info.id = id
        info.level = req.level
        info.type = req.type
        info.url = req.url
        info.comment = req.comment ?: ""
        layoutRepo.save(info)
        val ext = req.file.originalFilename?.substringAfter(".", "jpg") ?: "jpg"
        val path = "layouts/${req.level}/${req.type}/$id.$ext"
        imageRepo.upload(path, req.file.inputStream)
    }
}
