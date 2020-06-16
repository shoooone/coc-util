package com.shooone.cocapiproxy.infrastructure.sss

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.shooone.cocapiproxy.domain.repository.ImageRepository
import com.shooone.cocapiproxy.infrastructure.AWSSettings
import org.springframework.stereotype.Repository
import java.io.InputStream

@Repository
class S3ImageRepository(val client: AmazonS3, val settings: AWSSettings) : ImageRepository {
    override fun upload(path: String, inputStream: InputStream): String {
        val putRequest = PutObjectRequest(settings.bucket, path, inputStream, ObjectMetadata())
        putRequest.cannedAcl = CannedAccessControlList.BucketOwnerFullControl
        client.putObject(putRequest)
        return path
    }
}


