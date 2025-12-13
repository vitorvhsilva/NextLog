package br.com.nextlog.order_service.domain

enum class PaymentTypeEnum {
    CREDIT_CARD,
    DEBIT_CARD,
    PIX;

    companion object {
        fun fromInt(value: Int): PaymentTypeEnum {
            return when (value) {
                0 -> CREDIT_CARD
                1 -> DEBIT_CARD
                2 -> PIX
                else -> throw IllegalArgumentException("Invalid payment type value: $value")
            }
        }
    }
}