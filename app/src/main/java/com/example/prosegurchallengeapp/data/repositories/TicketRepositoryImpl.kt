package com.example.prosegurchallengeapp.data.repositories

import com.example.prosegurchallengeapp.core.Either
import com.example.prosegurchallengeapp.data.datasources.local.dao.TicketDao
import com.example.prosegurchallengeapp.data.datasources.local.entity.TicketEntity
import com.example.prosegurchallengeapp.data.datasources.local.mapper.TicketMapperData
import com.example.prosegurchallengeapp.domain.entities.TicketDomain
import com.example.prosegurchallengeapp.domain.repositories.TicketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

/**
 * Created by Kevin Breña on 02/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
class TicketRepositoryImpl(private val ticketDao: TicketDao,
                           private val mapperData: TicketMapperData): TicketRepository {

    override suspend fun getAllTickets(): Flow<Either<List<TicketDomain>>> {
        return flow<Either<List<TicketDomain>>> {
            ticketDao.getTickets().map {
                mapperData.mapperTicketEntityToTicketDomain(it)
            }.catch {
                emit(Either.Failure(it.stackTraceToString()))
            }.collect{
                emit(Either.Success(it))
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun registerTicket(ticketEntity: TicketEntity): Flow<Either<Boolean>> {
        return flow<Either<Boolean>> {
            val ticketInsert = ticketDao.saveTicket(ticketEntity)
            emit(Either.Success(ticketInsert > -1))
        }.catch {
            emit(Either.Failure(it.stackTraceToString()))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun deleteTicketById(idTicket: Long): Flow<Either<Boolean>> {
        return flow<Either<Boolean>> {
            ticketDao.deleteTicketById(idTicket)
            emit(Either.Success(true))
        }.catch {
            emit(Either.Failure(it.stackTraceToString()))
        }.flowOn(Dispatchers.IO)
    }
}