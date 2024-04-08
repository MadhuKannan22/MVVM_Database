package com.example.mvvm_database_task

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel(private val registerRepository: RegisterRepository, application: Application) :
    AndroidViewModel(application) {

    private val _loginResult = MutableLiveData<Boolean>()

    val loginResult: LiveData<Boolean>
        get() = _loginResult

    fun loginUser(userName: String, password: String) {

        viewModelScope.launch {

            val result = registerRepository.verifyUser(userName, password)
            _loginResult.value = result
        }
    }

}