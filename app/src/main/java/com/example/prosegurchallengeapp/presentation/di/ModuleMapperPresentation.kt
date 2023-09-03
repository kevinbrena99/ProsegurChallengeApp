package com.example.prosegurchallengeapp.presentation.di

import com.example.prosegurchallengeapp.presentation.mappers.TicketMapperPresentation
import com.example.prosegurchallengeapp.presentation.mappers.TicketMapperPresentationImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Kevin Breña on 03/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
@Module
@InstallIn(SingletonComponent::class)
object ModuleMapperPresentation {

    @Singleton
    @Provides
    fun provideTicketMapperPresentation(): TicketMapperPresentation = TicketMapperPresentationImpl()

}