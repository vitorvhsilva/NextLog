package br.com.nextlog.delivery_man_service.adapters.input.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/delivery-man")
class DeliveryManController(

) {
    @PostMapping
    fun createDeliveryMan(): ResponseEntity<Any>{



        return ResponseEntity.ok().build()
    }
}