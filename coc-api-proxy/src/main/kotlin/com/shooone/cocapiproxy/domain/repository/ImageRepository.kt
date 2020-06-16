package com.shooone.cocapiproxy.domain.repository

import java.io.InputStream

interface ImageRepository {

    /** ストリームをアップロードし、URLを返却*/
    fun upload(path: String, inputStream: InputStream): String
}
