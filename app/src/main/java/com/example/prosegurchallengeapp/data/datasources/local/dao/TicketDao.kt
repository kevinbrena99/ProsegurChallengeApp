package com.example.prosegurchallengeapp.data.datasources.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.prosegurchallengeapp.data.datasources.local.entity.TicketEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Kevin Breña on 02/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
@Dao
interface TicketDao {

    @Query("SELECT * FROM TICKETS")
    fun getTickets(): Flow<List<TicketEntity>>

    @Insert
    suspend fun saveTicket(ticketEntity: TicketEntity): Long

    @Query("DELETE FROM tickets WHERE id = :idTicket")
    suspend fun deleteTicketById(idTicket: Long)

}