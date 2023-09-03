package com.example.prosegurchallengeapp.presentation.mappers

import com.example.prosegurchallengeapp.domain.entities.TicketDomain
import com.example.prosegurchallengeapp.presentation.enums.DayOfWeekEnum
import com.example.prosegurchallengeapp.presentation.models.TicketModel

/**
 * Created by Kevin Breña on 03/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
class TicketMapperPresentationImpl: TicketMapperPresentation {
    override suspend fun mapperTicketsDomainToTicketsModel(tickets: List<TicketDomain>): List<TicketModel> {
        return tickets.map {
            TicketModel(
                numberCinema = it.numberCinema,
                dayOfWeek =  DayOfWeekEnum.findDayOfWeekEnum(it.dayOfWeek)!!,
                nameMovie = it.nameMovie,
                price = it.price,
                totalAmount = it.totalAmount,
                quantityTicket = it.quantityTicket,
                dniUser = it.dniUser,
                id = it.id
            )
        }
    }

}