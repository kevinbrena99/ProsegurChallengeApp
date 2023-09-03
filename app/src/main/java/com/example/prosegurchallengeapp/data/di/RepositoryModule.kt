package com.example.prosegurchallengeapp.data.di

import com.example.prosegurchallengeapp.data.datasources.local.dao.TicketDao
import com.example.prosegurchallengeapp.data.datasources.local.mapper.TicketMapperData
import com.example.prosegurchallengeapp.data.repositories.TicketRepositoryImpl
import com.example.prosegurchallengeapp.domain.repositories.TicketRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Kevin Breña on 02/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideTicketRepository(ticketDao: TicketDao, mapperData: TicketMapperData): TicketRepository{
        return TicketRepositoryImpl(ticketDao, mapperData)
    }

}