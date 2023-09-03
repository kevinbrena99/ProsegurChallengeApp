package com.example.prosegurchallengeapp.domain.usecases

import com.example.prosegurchallengeapp.domain.repositories.TicketRepository

/**
 * Created by Kevin Breña on 03/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
class DeleteTicketByIdUseCase(private val repository: TicketRepository) {

    suspend fun invoke(idTicket: Long) = repository.deleteTicketById(idTicket)

}