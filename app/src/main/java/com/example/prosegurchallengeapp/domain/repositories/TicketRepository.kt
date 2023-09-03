package com.example.prosegurchallengeapp.domain.repositories

import com.example.prosegurchallengeapp.core.Either
import com.example.prosegurchallengeapp.data.datasources.local.entity.TicketEntity
import com.example.prosegurchallengeapp.domain.entities.TicketDomain
import kotlinx.coroutines.flow.Flow

/**
 * Created by Kevin Breña on 02/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
interface TicketRepository {

    suspend fun getAllTickets(): Flow<Either<List<TicketDomain>>>

    suspend fun registerTicket(ticketEntity: TicketEntity): Flow<Either<Boolean>>

    suspend fun deleteTicketById(idTicket: Long): Flow<Either<Boolean>>

}