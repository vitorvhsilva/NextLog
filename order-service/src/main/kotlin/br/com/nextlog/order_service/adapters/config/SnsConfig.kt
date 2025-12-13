package br.com.nextlog.order_service.adapters.config

import io.awspring.cloud.sns.core.SnsTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.sns.SnsClient
import java.net.URI


@Configuration
class SnsConfig {
    @Bean
    fun snsClient(): SnsClient {
        return SnsClient.builder()
            .region(Region.US_EAST_1)
            .endpointOverride(URI.create("http://localhost:4566"))
            .credentialsProvider(
                StaticCredentialsProvider.create(
                    AwsBasicCredentials.create("test", "test")
                )
            )
            .build()
    }

    @Bean
    fun snsTemplate(snsClient: SnsClient): SnsTemplate {
        return SnsTemplate(snsClient)
    }
}