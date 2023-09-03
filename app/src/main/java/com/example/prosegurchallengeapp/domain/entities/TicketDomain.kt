package com.example.prosegurchallengeapp.domain.entities

/**
 * Created by Kevin Breña on 02/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
data class TicketDomain(
    val numberCinema: Int,
    val dayOfWeek: String,
    val nameMovie: String,
    val price: Double,
    val totalAmount: Double,
    val quantityTicket: Int,
    val dniUser: String,
    val id: Long
)
