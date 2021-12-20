package com.example.databaseexample.Klass

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class KlassListViewModelFactory(
     private val application: Application
) :ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(KlassListViewModel::class.java)) {
            return KlassListViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}