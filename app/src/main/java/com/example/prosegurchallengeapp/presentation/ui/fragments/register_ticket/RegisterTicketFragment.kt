package com.example.prosegurchallengeapp.presentation.ui.fragments.register_ticket

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
import androidx.navigation.fragment.findNavController
import com.example.prosegurchallengeapp.R
import com.example.prosegurchallengeapp.databinding.FragmentRegisterTicketBinding
import com.example.prosegurchallengeapp.presentation.common.UiState
import com.example.prosegurchallengeapp.presentation.common.extensions.clearField
import com.example.prosegurchallengeapp.presentation.common.extensions.showToast
import com.example.prosegurchallengeapp.presentation.enums.DayOfWeekEnum
import com.example.prosegurchallengeapp.presentation.models.TicketModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterTicketFragment : Fragment() {

    private val myViewModel: RegisterTicketViewModel by viewModels()

    private val binding by lazy {
        FragmentRegisterTicketBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            val numberCinema = binding.edtNumberCinema.text.toString().toInt()
            val dayOfWeek = DayOfWeekEnum.findDayOfWeekEnum(binding.edtDay.text.toString().uppercase())
            val nameMovie = binding.edtNameMovie.text.toString()
            val price = binding.edtPrice.text.toString().toDouble()
            val quantity = binding.edtQuantity.text.toString().toInt()
            val dni = binding.edtDni.text.toString()

            dayOfWeek?.let {
                val ticket = TicketModel(numberCinema,dayOfWeek,nameMovie,price,quantity,dni)
                myViewModel.registerTicket(ticket)
            } ?: run {
                showToast("Introducir opcion valida")
            }
        }

        binding.btnShowList.setOnClickListener {
            findNavController().navigate(R.id.ticketListFragment)
        }


        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){

                launch {
                    myViewModel.registerIsSuccess.collect{
                        when(it){
                            is UiState.Success -> {
                                showToast("Reserva agregada")
                                clearFields()
                            }

                            is UiState.Error -> showToast(it.message)

                            else -> Log.d(RegisterTicketFragment::class.java.simpleName,"Otras acciones")
                        }
                    }
                }
            }
        }

    }

    private fun clearFields(){
        with(binding){
            this.edtNumberCinema.clearField()
            this.edtDay.clearField()
            this.edtNameMovie.clearField()
            this.edtPrice.clearField()
            this.edtQuantity.clearField()
            this.edtDni.clearField()
        }
    }



}