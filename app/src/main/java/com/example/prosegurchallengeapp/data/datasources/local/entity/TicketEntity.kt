package com.example.prosegurchallengeapp.data.datasources.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Kevin Breña on 02/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
@Entity(tableName = "tickets")
data class TicketEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val numberCinema: Int,
    val dayOfWeek: String,
    val nameMovie: String,
    val price: Double,
    val totalAmount: Double,
    val quantityTicket: Int,
    val dniUser: String
)