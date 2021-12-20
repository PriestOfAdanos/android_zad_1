package com.example.databaseexample.Klass

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddKlassViewModelFactory(
    private val application: Application


): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddKlassViewModel::class.java)) {
            return AddKlassViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}