package br.com.nextlog.order_service.application.ports.output

import br.com.nextlog.order_service.domain.Order

interface OrderCreatedPublisher {
    fun publish(order: Order)
}