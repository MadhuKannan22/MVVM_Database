package com.example.mvvm_database_task

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateViewModel(
    private val registerRepository: RegisterRepository,
    application: Application
) : AndroidViewModel(application) {


    fun updateUserData(registerEntity: RegisterEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            registerRepository.updateUser(registerEntity)
        }
    }
}

