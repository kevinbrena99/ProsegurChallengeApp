package com.example.prosegurchallengeapp.presentation.ui.fragments.list_ticket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prosegurchallengeapp.core.Either
import com.example.prosegurchallengeapp.domain.usecases.DeleteTicketByIdUseCase
import com.example.prosegurchallengeapp.domain.usecases.GetTicketsUseCase
import com.example.prosegurchallengeapp.presentation.common.UiState
import com.example.prosegurchallengeapp.presentation.mappers.TicketMapperPresentation
import com.example.prosegurchallengeapp.presentation.models.TicketModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Kevin Breña on 03/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
@HiltViewModel
class TicketListViewModel @Inject constructor(
    private val getTicketsUseCase: GetTicketsUseCase,
    private val deleteTicketByIdUseCase: DeleteTicketByIdUseCase,
    private val ticketMapperPresentation: TicketMapperPresentation
): ViewModel() {

    private val _tickets = MutableStateFlow<UiState<List<TicketModel>>>(UiState.Init)
    val tickets = _tickets.asStateFlow()

    private val _deleteSuccess = MutableStateFlow<UiState<Boolean>>(UiState.Init)
    val deleteSuccess = _deleteSuccess.asStateFlow()

    init {
        getTickets()
    }

    private fun getTickets(){
        viewModelScope.launch {
            getTicketsUseCase.invoke()
                .collect{
                    when(it){
                        is Either.Success -> _tickets.emit(UiState.Success(ticketMapperPresentation.mapperTicketsDomainToTicketsModel(it.data)))
                        is Either.Failure -> _tickets.emit(UiState.Error(it.error))
                    }
                }
        }
    }

    fun deleteTicketById(idTicket: Long){
        viewModelScope.launch {
            deleteTicketByIdUseCase.invoke(idTicket)
                .collect{
                    when(it){
                        is Either.Success -> _deleteSuccess.emit(UiState.Success(it.data))
                        is Either.Failure -> _deleteSuccess.emit(UiState.Error(it.error))
                    }
                }
        }
    }

}