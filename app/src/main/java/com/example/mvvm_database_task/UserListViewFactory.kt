package com.example.login_mvvm_task.userList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_database_task.RegisterRepository


class UserListViewFactory(
    private val application: Application,
    private val registerRepository: RegisterRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserListViewModel::class.java)) {
            return UserListViewModel(registerRepository, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
