package com.example.prosegurchallengeapp.domain.usecases

import com.example.prosegurchallengeapp.data.datasources.local.entity.TicketEntity
import com.example.prosegurchallengeapp.domain.repositories.TicketRepository
import com.example.prosegurchallengeapp.presentation.models.TicketModel

/**
 * Created by Kevin Breña on 02/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
class RegisterTicketUseCase(private val ticketRepository: TicketRepository) {

    suspend fun invoke(params: TicketModel) = ticketRepository.registerTicket(
        TicketEntity(
            numberCinema = params.numberCinema,
            dayOfWeek = params.dayOfWeek.name,
            nameMovie = params.nameMovie,
            price = params.price,
            totalAmount = params.totalAmountWithDiscountByDay(),
            quantityTicket = params.quantityTicket,
            dniUser = params.dniUser
        )
    )
}