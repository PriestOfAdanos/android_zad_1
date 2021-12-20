package com.example.databaseexample.Klass

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.databaseexample.KlassDAO
import com.example.databaseexample.UsersDatabase
import com.example.databaseexample.enitities.Klass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AddKlassViewModel(application: Application): AndroidViewModel(application) {

          private val klassDAO : KlassDAO = UsersDatabase.getInstance(application).klassDAO

    fun addKlass(klass: Klass) {

               //Toast.makeText(getApplication(),user.toString(),Toast.LENGTH_LONG).show()

               viewModelScope.launch(Dispatchers.IO){
                  klassDAO.insertKlass(klass)
             }
        }

}