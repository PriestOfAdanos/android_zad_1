package com.example.databaseexample.Users

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UsersListViewModelFactory(
     private val application: Application
) :ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UsersListViewModel::class.java)) {
            return UsersListViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}