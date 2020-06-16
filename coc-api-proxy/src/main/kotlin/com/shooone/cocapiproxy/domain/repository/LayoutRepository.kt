package com.shooone.cocapiproxy.domain.repository

import com.shooone.cocapiproxy.domain.model.LayoutInfo

interface LayoutRepository {
    fun save(info: LayoutInfo)
}
