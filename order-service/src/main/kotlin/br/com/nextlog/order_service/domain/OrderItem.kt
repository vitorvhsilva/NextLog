package br.com.nextlog.order_service.domain

import java.util.UUID

data class OrderItem(
    val id: UUID,
    val amount: Int
)