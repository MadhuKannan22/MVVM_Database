package com.example.mvvm_database_task

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface  RegisterDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(registerEntity: RegisterEntity)

    @Query("SELECT * FROM user_table")
    fun getAllUsers(): Flow<List<RegisterEntity>>


    @Query("SELECT * FROM user_table WHERE username = :userName")
    suspend fun getUserByUsername(userName: String): RegisterEntity?

    @Query("SELECT * FROM user_table WHERE password = :Password")
    suspend fun getUserByPassword(Password: String): RegisterEntity?

    @Update
    suspend fun updateUser(registerEntity: RegisterEntity)


}