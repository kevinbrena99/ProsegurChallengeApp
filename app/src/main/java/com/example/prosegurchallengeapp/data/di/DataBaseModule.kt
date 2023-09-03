package com.example.prosegurchallengeapp.data.di

import android.content.Context
import com.example.prosegurchallengeapp.data.datasources.local.ProsegurChallengeDataBase
import com.example.prosegurchallengeapp.data.datasources.local.dao.TicketDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
object DataBaseModule {

    @Singleton
    @Provides
    fun provideDataBaseRoom(@ApplicationContext applicationContext: Context): ProsegurChallengeDataBase{
        return ProsegurChallengeDataBase.getInstanceDB(applicationContext)
    }

    @Singleton
    @Provides
    fun provideTicketDao(database: ProsegurChallengeDataBase): TicketDao{
        return database.ticketDao()
    }

}