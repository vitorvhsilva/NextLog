package br.com.nextlog.delivery_man_service.adapters.output.persistence.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.UUID


@Entity
@Table(
    name = "delivery_man"
)
data class DeliveryManEntity(

    @Id
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "uuid")
    val id: UUID,

    @Column(name = "nome", nullable = false, length = 100)
    val nome: String,

    @Column(name = "email", nullable = false, length = 150, unique = true)
    val email: String,

    @Column(name = "estado", nullable = false, length = 2)
    val estado: String,

    @OneToMany(
        mappedBy = "deliveryMan",
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    val schedules: MutableList<WorkingScheduleEntity> = mutableListOf()
)