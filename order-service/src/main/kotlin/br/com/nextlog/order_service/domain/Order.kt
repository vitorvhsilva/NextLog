package br.com.nextlog.order_service.domain

import java.util.UUID

data class Order (
    val id: UUID,
    val costumerId: UUID,
    val paymentType: PaymentTypeEnum,
    val items: List<OrderItem>
)