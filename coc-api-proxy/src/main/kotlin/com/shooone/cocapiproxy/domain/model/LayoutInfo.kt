package com.shooone.cocapiproxy.domain.model

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey

@DynamoDbBean
class LayoutInfo {
    @get:DynamoDbPartitionKey
    lateinit var id: String
    lateinit var level: String
    lateinit var type: String
    lateinit var url: String
    lateinit var comment: String
}
