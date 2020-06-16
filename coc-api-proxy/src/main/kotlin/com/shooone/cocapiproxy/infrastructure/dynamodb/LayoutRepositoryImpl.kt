package com.shooone.cocapiproxy.infrastructure.dynamodb

import com.shooone.cocapiproxy.domain.model.LayoutInfo
import com.shooone.cocapiproxy.domain.repository.LayoutRepository
import com.shooone.cocapiproxy.infrastructure.AWSSettings
import org.springframework.stereotype.Repository
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.TableSchema

@Repository
class LayoutRepositoryImpl(
        final val dynamodb: DynamoDbEnhancedClient,
        final val settings: AWSSettings) : LayoutRepository {
    var table: DynamoDbTable<LayoutInfo> = dynamodb.table(settings.dynamo, TableSchema.fromBean(LayoutInfo::class.java))

    override fun save(info: LayoutInfo) {
        table.putItem(info)
    }

}
