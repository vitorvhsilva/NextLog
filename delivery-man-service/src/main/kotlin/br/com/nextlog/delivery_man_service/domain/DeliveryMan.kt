package br.com.nextlog.delivery_man_service.domain

import java.util.UUID

data class DeliveryMan(

    val id: UUID,

    val nome: String,

    val email: String,

    val estado: String,

    val schedules: MutableList<WorkingSchedule> = mutableListOf()
)