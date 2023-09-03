package com.example.prosegurchallengeapp.data.datasources.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.prosegurchallengeapp.data.datasources.local.dao.TicketDao
import com.example.prosegurchallengeapp.data.datasources.local.entity.TicketEntity

/**
 * Created by Kevin Breña on 02/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
@Database(entities = [TicketEntity::class], version = 1, exportSchema = false)
abstract class ProsegurChallengeDataBase: RoomDatabase() {

    abstract fun ticketDao(): TicketDao

    companion object{

        private const val DATABASE_NAME = "prosegur_challenge_database"

        @Volatile
        private var INSTANCE: ProsegurChallengeDataBase? = null


        fun getInstanceDB(context: Context): ProsegurChallengeDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProsegurChallengeDataBase::class.java,
                    DATABASE_NAME
                )
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }


}