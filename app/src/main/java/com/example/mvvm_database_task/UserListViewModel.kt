package com.example.login_mvvm_task.userList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mvvm_database_task.RegisterEntity
import com.example.mvvm_database_task.RegisterRepository
import kotlinx.coroutines.flow.Flow

class UserListViewModel(
    registerRepository: RegisterRepository,
    application: Application
) : AndroidViewModel(application) {
    val userList: Flow<List<RegisterEntity>> = registerRepository.getAllUsers()


}
