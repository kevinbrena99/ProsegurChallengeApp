package com.example.prosegurchallengeapp.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.prosegurchallengeapp.databinding.ItemTicketBinding
import com.example.prosegurchallengeapp.presentation.models.TicketModel

/**
 * Created by Kevin Breña on 03/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
class TicketAdapter(private val deleteTicket:(id: Long) -> Unit): RecyclerView.Adapter<TicketAdapter.TicketViewHolder>(){

    private val ticketList: ArrayList<TicketModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        return TicketViewHolder(ItemTicketBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = ticketList.size

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val ticket = ticketList[position]
        holder.bind(ticket)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setTickets(tickets: List<TicketModel>){
        ticketList.clear()
        ticketList.addAll(tickets)
        notifyDataSetChanged()
    }

    inner class TicketViewHolder(val binding: ItemTicketBinding): ViewHolder(binding.root){

        fun bind(ticket: TicketModel){
            binding.tvDetail.text = ticket.toString()
            binding.btnDelete.setOnClickListener {
                deleteTicket.invoke(ticket.id)
            }
        }

    }

}