package br.com.nextlog.order_service.application.ports.input

import br.com.nextlog.order_service.domain.Order

interface CreateOrderUseCase {
    fun createOrder(order: Order)
}