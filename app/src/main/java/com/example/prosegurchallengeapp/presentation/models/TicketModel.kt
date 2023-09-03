package com.example.prosegurchallengeapp.presentation.models

import com.example.prosegurchallengeapp.presentation.enums.DayOfWeekEnum

/**
 * Created by Kevin Breña on 02/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
data class TicketModel(
    val numberCinema: Int,
    val dayOfWeek: DayOfWeekEnum,
    val nameMovie: String,
    val price: Double,
    val quantityTicket: Int,
    val dniUser: String,
    val totalAmount: Double = 0.0,
    val id: Long = 0
){

    fun totalAmountWithDiscountByDay(): Double{
        return when(dayOfWeek){
            DayOfWeekEnum.MONDAY,DayOfWeekEnum.WEDNESDAY,DayOfWeekEnum.THURSDAY -> price * 0.7 * quantityTicket
            DayOfWeekEnum.TUESDAY -> price * 0.5 * quantityTicket
            DayOfWeekEnum.FRIDAY, DayOfWeekEnum.SATURDAY, DayOfWeekEnum.SUNDAY -> price * 0.6 * quantityTicket
        }
    }

}
