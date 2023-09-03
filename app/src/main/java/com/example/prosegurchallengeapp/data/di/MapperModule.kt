package com.example.prosegurchallengeapp.data.di

import com.example.prosegurchallengeapp.data.datasources.local.mapper.TicketMapperData
import com.example.prosegurchallengeapp.data.datasources.local.mapper.TicketMapperDataImpl
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
object MapperModule {

    @Singleton
    @Provides
    fun provideTicketMapperData(): TicketMapperData = TicketMapperDataImpl()

}