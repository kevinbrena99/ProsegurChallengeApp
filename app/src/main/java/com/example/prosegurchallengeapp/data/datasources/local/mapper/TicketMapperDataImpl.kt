package com.example.prosegurchallengeapp.data.datasources.local.mapper

import com.example.prosegurchallengeapp.data.datasources.local.entity.TicketEntity
import com.example.prosegurchallengeapp.domain.entities.TicketDomain

/**
 * Created by Kevin Breña on 02/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
class TicketMapperDataImpl: TicketMapperData {
    override suspend fun mapperTicketEntityToTicketDomain(ticket: List<TicketEntity>): List<TicketDomain> {
        return ticket.map {
            TicketDomain(
                numberCinema = it.numberCinema,
                nameMovie = it.nameMovie,
                dayOfWeek = it.dayOfWeek,
                price = it.price,
                totalAmount = it.totalAmount,
                quantityTicket = it.quantityTicket,
                dniUser = it.dniUser,
                id = it.id
            )
        }
    }
}