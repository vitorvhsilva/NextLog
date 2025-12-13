package br.com.nextlog.order_service.adapters.output.topic

import br.com.nextlog.order_service.application.ports.output.OrderCreatedPublisher
import br.com.nextlog.order_service.domain.Order
import io.awspring.cloud.sns.core.SnsTemplate
import org.springframework.stereotype.Service



@Service
class OrderCreatedPublisherImpl(
    private val snsTemplate: SnsTemplate
): OrderCreatedPublisher {
    override fun publish(order: Order) {
        snsTemplate.convertAndSend(TOPIC_ARN, order)
    }

    companion object {
        private const val TOPIC_ARN = "arn:aws:sns:us-east-1:000000000000:pedidos-topic";
    }
}