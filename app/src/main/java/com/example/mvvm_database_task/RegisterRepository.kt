package com.example.mvvm_database_task

import kotlinx.coroutines.flow.Flow

class RegisterRepository(private val registerDatabaseDao: RegisterDatabaseDao) {

    suspend fun insertUser(registerEntity: RegisterEntity) {
        return registerDatabaseDao.insertUser(registerEntity)
    }

    suspend fun updateUser(registerEntity: RegisterEntity) {
        return registerDatabaseDao.updateUser(registerEntity)
    }

    fun getAllUsers(): Flow<List<RegisterEntity>> {
        return registerDatabaseDao.getAllUsers()

    }

    suspend fun isUserExist(Username: String): Boolean {
        return registerDatabaseDao.getUserByUsername(Username) != null

    }

    suspend fun verifyUser(Username: String, Password: String): Boolean {
        val user = registerDatabaseDao.getUserByUsername(Username)
        return user?.Password == Password

    }


}