package com.example.prosegurchallengeapp.domain.usecases

import com.example.prosegurchallengeapp.domain.repositories.TicketRepository

/**
 * Created by Kevin Breña on 02/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
class GetTicketsUseCase(private val ticketRepository: TicketRepository) {

    suspend fun invoke() = ticketRepository.getAllTickets()

}