package com.example.prosegurchallengeapp.domain.di

import com.example.prosegurchallengeapp.domain.repositories.TicketRepository
import com.example.prosegurchallengeapp.domain.usecases.DeleteTicketByIdUseCase
import com.example.prosegurchallengeapp.domain.usecases.GetTicketsUseCase
import com.example.prosegurchallengeapp.domain.usecases.RegisterTicketUseCase
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
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetTicketUseCase(ticketRepository: TicketRepository) = GetTicketsUseCase(ticketRepository)

    @Singleton
    @Provides
    fun provideRegisterTicketUseCase(ticketRepository: TicketRepository) = RegisterTicketUseCase(ticketRepository)

    @Singleton
    @Provides
    fun provideDeleteTicketByIdUseCase(ticketRepository: TicketRepository) = DeleteTicketByIdUseCase(ticketRepository)

}