package com.example.databaseexample.Users

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.databaseexample.UsersDatabase
import com.example.databaseexample.enitities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersListViewModel(
    application: Application):
          AndroidViewModel(application) {

    private val usersDAO : UsersDAO = UsersDatabase.getInstance(application).usersDAO
    val users:LiveData<List<User>> = usersDAO.getAll()



    fun deleteUser(user: User)
    {
        viewModelScope.launch(Dispatchers.IO) {
            usersDAO.deleteUser(user)
        }
    }


}