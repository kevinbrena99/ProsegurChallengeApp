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
interface TicketMapperData {

    suspend fun mapperTicketEntityToTicketDomain(ticket: List<TicketEntity>): List<TicketDomain>

}