package com.example.prosegurchallengeapp.presentation.ui.fragments.register_ticket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prosegurchallengeapp.core.Either
import com.example.prosegurchallengeapp.domain.usecases.RegisterTicketUseCase
import com.example.prosegurchallengeapp.presentation.common.UiState
import com.example.prosegurchallengeapp.presentation.models.TicketModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Kevin Breña on 02/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
@HiltViewModel
class RegisterTicketViewModel @Inject constructor(
    private val registerTicketUseCase: RegisterTicketUseCase
): ViewModel() {

    private val _registerSuccess = MutableStateFlow<UiState<Boolean>>(UiState.Init)
    val registerIsSuccess = _registerSuccess.asStateFlow()

    fun registerTicket(ticket: TicketModel){
        viewModelScope.launch {
            registerTicketUseCase.invoke(ticket)
                .catch {
                    _registerSuccess.emit(UiState.Error(it.stackTraceToString()))
                }.collect{
                    when(it){
                        is Either.Success -> _registerSuccess.emit(UiState.Success(it.data))
                        is Either.Failure -> _registerSuccess.emit(UiState.Error(it.error))
                    }
                    _registerSuccess.emit(UiState.Init)
                }
        }
    }

}