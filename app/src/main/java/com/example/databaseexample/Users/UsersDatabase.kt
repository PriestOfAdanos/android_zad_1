package com.example.databaseexample.Users

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.databaseexample.KlassDAO
import com.example.databaseexample.enitities.User

@Database(entities=[User::class], version = 1, exportSchema = false)
abstract class UsersDatabase: RoomDatabase() {

    abstract val usersDAO: UsersDAO
    abstract val klassDAO: KlassDAO


    companion object {

        @Volatile
        private var INSTANCE: UsersDatabase? = null

        fun getInstance(context: Context): UsersDatabase {
              synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UsersDatabase::class.java,
                        "users_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}