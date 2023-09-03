package com.example.prosegurchallengeapp.presentation.common.extensions

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * Created by Kevin Breña on 03/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/

fun Fragment.showToast(message: String){
    Toast.makeText(this.requireContext(), message, Toast.LENGTH_SHORT).show()
}