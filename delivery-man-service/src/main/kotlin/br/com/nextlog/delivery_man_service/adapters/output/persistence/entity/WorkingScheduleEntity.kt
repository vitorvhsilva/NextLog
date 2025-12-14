package br.com.nextlog.delivery_man_service.adapters.output.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

@Entity
@Table(name = "working_schedule")
data class WorkingScheduleEntity(

    @Id
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "uuid")
    val id: UUID,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "delivery_man_id",
        nullable = false
    )
    val deliveryMan: DeliveryManEntity,

    @Column(name = "dia", nullable = false)
    val dia: LocalDate,

    @Column(name = "horario_entrada", nullable = false)
    val horarioEntrada: LocalTime,

    @Column(name = "horario_saida", nullable = false)
    val horarioSaida: LocalTime
)