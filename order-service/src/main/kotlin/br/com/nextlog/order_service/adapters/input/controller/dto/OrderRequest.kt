package br.com.nextlog.order_service.adapters.input.controller.dto

import br.com.nextlog.order_service.domain.Order
import br.com.nextlog.order_service.domain.OrderItem
import br.com.nextlog.order_service.domain.PaymentTypeEnum
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.UUID

@JsonIgnoreProperties(ignoreUnknown = true)
data class OrderRequest(
    val costumerId: UUID,
    val paymentType: Int,
    val items: List<OrderRequestItem>
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class OrderRequestItem(
        val id: UUID,
        val amount: Int
    )

    fun toDomain(): Order {
        return Order(
            id = UUID.randomUUID(),
            costumerId = this.costumerId,
            paymentType = PaymentTypeEnum.fromInt(this.paymentType),
            items = this.items.map {
                OrderItem(
                    id = it.id,
                    amount = it.amount
                )
            }
        )
    }
}
