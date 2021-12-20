package com.example.databaseexample.Klass

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.databaseexample.KlassDAO
import com.example.databaseexample.Users.UsersDAO
import com.example.databaseexample.enitities.Klass


@Database(entities=[Klass::class], version = 1, exportSchema = false)
abstract class KlassDatabase: RoomDatabase() {

    abstract val klassDAO: KlassDAO
    abstract val usersDAO: UsersDAO

    companion object {

        @Volatile
        private var INSTANCE: KlassDatabase? = null

        fun getInstance(context: Context): KlassDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        KlassDatabase::class.java,
                        "klass_database"
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