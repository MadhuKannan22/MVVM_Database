package com.example.mvvm_database_task

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CreateUserViewFactory(
    private val application: Application,
    private val registerRepository: RegisterRepository

) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreateUserViewModel::class.java)) {
            return CreateUserViewModel(registerRepository,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}