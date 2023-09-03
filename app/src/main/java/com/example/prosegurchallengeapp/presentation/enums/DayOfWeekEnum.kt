package com.example.prosegurchallengeapp.presentation.enums

/**
 * Created by Kevin Breña on 02/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
enum class DayOfWeekEnum(val abbreviated: String, val fullDescription: String) {
    MONDAY("LU","LUNES"),
    TUESDAY("MA","MARTES"),
    WEDNESDAY("MI", "MIERCOLES"),
    THURSDAY("JU", "JUEVES"),
    FRIDAY("VI", "VIERNES"),
    SATURDAY("SA", "SABADO"),
    SUNDAY("DO", "DOMINGO");

    companion object{
        fun findDayOfWeekEnum(abbreviated: String) = values().find { it.abbreviated == abbreviated  || it.name == abbreviated}
    }
}