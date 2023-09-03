package com.example.prosegurchallengeapp.presentation.mappers

import com.example.prosegurchallengeapp.domain.entities.TicketDomain
import com.example.prosegurchallengeapp.presentation.models.TicketModel

/**
 * Created by Kevin Breña on 03/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
interface TicketMapperPresentation {

    suspend fun mapperTicketsDomainToTicketsModel(tickets: List<TicketDomain>): List<TicketModel>

}