package br.com.nextlog.order_service.application.usecases

import br.com.nextlog.order_service.application.ports.input.CreateOrderUseCase
import br.com.nextlog.order_service.application.ports.output.OrderCreatedPublisher
import br.com.nextlog.order_service.domain.Order
import org.springframework.stereotype.Service

@Service
class CreateOrderUseCaseImpl(
    private val orderCreatedPublisher: OrderCreatedPublisher
): CreateOrderUseCase {
    override fun createOrder(order: Order) {
        //TODO("integrar com produtos e payments")
        orderCreatedPublisher.publish(order)
    }
}