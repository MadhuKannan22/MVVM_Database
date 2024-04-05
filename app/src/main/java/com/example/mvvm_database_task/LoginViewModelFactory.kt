package com.example.mvvm_database_task

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class LoginViewModelFactory(
    private val application: Application,
    private val registerRepository: RegisterRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(registerRepository, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}