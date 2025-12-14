package br.com.nextlog.delivery_man_service.domain

import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

data class WorkingSchedule (

    val id: UUID,

    val dia: LocalDate,

    val horarioEntrada: LocalTime,

    val horarioSaida: LocalTime
)