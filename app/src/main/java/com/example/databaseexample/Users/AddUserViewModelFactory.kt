package com.example.databaseexample.Users

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddUserViewModelFactory(
    private val application: Application


): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddUserViewModel::class.java)) {
            return AddUserViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}