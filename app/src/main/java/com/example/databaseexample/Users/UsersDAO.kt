package com.example.databaseexample.Users

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.databaseexample.enitities.User

@Dao
interface UsersDAO  {

    @Insert
    fun insertUser(user: User)

    @Delete
    fun deleteUser(user:User)

    @Query("SELECT * FROM users_table")
    fun getAll(): LiveData<List<User>>



}