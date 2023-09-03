package com.example.prosegurchallengeapp.presentation.ui.fragments.list_ticket

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prosegurchallengeapp.databinding.FragmentTicketListBinding
import com.example.prosegurchallengeapp.presentation.common.UiState
import com.example.prosegurchallengeapp.presentation.common.extensions.showToast
import com.example.prosegurchallengeapp.presentation.ui.adapters.TicketAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TicketListFragment : Fragment() {

    private val myViewModel: TicketListViewModel by viewModels()

    private val ticketAdapter by lazy {
        TicketAdapter(){
            myViewModel.deleteTicketById(it)
            showToast("Eliminado $it")
        }
    }

    private val binding by lazy {
        FragmentTicketListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvTickets.apply {
            this.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL, false)
            this.adapter = ticketAdapter
        }

        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){

                launch {
                    myViewModel.tickets.collect{
                        when(it){
                            is UiState.Success -> {
                               ticketAdapter.setTickets(it.data)
                            }

                            is UiState.Error -> showToast(it.message)

                            else -> Log.d(TicketListFragment::class.java.simpleName,"Otras acciones")
                        }
                    }
                }

            }
        }
    }


}