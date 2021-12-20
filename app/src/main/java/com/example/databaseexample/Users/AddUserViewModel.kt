package com.example.databaseexample.Users

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.databaseexample.UsersDatabase
import com.example.databaseexample.enitities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AddUserViewModel(application: Application): AndroidViewModel(application) {

          private val usersDAO : UsersDAO
          init{
              usersDAO= UsersDatabase.getInstance(application).usersDAO
          }

           fun addUser(user: User) {

               //Toast.makeText(getApplication(),user.toString(),Toast.LENGTH_LONG).show()

               viewModelScope.launch(Dispatchers.IO){
                  usersDAO.insertUser(user)
             }
        }

}