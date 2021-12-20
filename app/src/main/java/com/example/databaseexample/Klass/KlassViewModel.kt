package com.example.databaseexample.Klass

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.databaseexample.KlassDAO
import com.example.databaseexample.UsersDatabase
import com.example.databaseexample.enitities.Klass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KlassViewModel(
    application: Application):
    AndroidViewModel(application) {
        private val klassDAO : KlassDAO = UsersDatabase.getInstance(application).klassDAO
        val klass:LiveData<List<Klass>> = klassDAO.getAll()

        fun deleteKlass(klass: Klass)
        {
            viewModelScope.launch(Dispatchers.IO) {
                klassDAO.deleteKlass(klass)
            }
        }
//        fun getKlassWithStudents(klass: Klass)
//        {
//            viewModelScope.launch(Dispatchers.IO) {
//                klassDAO.getKlassWithStudents(klass)
//            }
//        }
}