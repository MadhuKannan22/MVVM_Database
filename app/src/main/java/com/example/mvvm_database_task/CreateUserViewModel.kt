package com.example.mvvm_database_task

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CreateUserViewModel(
    private val registerRepository: RegisterRepository,
    application: Application
) : AndroidViewModel(application) {

    fun saveUserData(username: String, password: String) {
        viewModelScope.launch {
            val registerEntity = RegisterEntity(0, username, password)
            /*val isAuthenticated = true
            if (isAuthenticated){
                registerRepository.insertUser(registerEntity)
                Toast.makeText(
                    getApplication(),
                    "Username and password saved successfully",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                Toast.makeText(
                    getApplication(),
                    "Username and password already exist",
                    Toast.LENGTH_SHORT
                ).show()

            }*/
            if (isUserExist(registerEntity)) {
                Toast.makeText(
                    getApplication(),
                    "Username and password already exist",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                registerRepository.insertUser(registerEntity)
                Toast.makeText(
                    getApplication(),
                    "Username and password saved successfully",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    suspend fun isUserExist(registerEntity: RegisterEntity): Boolean {
        return registerRepository.isUserExist(registerEntity.Username)
    }
}