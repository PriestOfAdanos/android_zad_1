package com.example.databaseexample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.databaseexample.Users.UsersDAO
import com.example.databaseexample.enitities.Klass
import com.example.databaseexample.enitities.User

@Database(entities=[User::class, Klass::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract val usersDAO: UsersDAO
    abstract val klassDAO: KlassDAO


    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
              synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database"
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