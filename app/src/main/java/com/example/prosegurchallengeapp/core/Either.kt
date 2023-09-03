package com.example.prosegurchallengeapp.core

/**
 * Created by Kevin Breña on 02/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
sealed class Either<out T>{

    data class Success<T>(val data: T): Either<T>()
    data class Failure<T>(val error: String): Either<T>()

}
