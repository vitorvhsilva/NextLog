package br.com.nextlog.order_service.adapters.input.controller

import br.com.nextlog.order_service.adapters.input.controller.dto.OrderRequest
import br.com.nextlog.order_service.adapters.input.controller.dto.OrderResponse
import br.com.nextlog.order_service.application.ports.input.CreateOrderUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("orders")
class OrderController(
    private val createOrderUseCase: CreateOrderUseCase
) {
    @PostMapping
    fun createOrder(orderRequest: OrderRequest): ResponseEntity<OrderResponse> {
        val order = orderRequest.toDomain()

        createOrderUseCase.createOrder(order)

        return ResponseEntity.status(HttpStatus.CREATED).body(OrderResponse(order.id))
    }
}