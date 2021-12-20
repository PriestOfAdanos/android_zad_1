package com.example.databaseexample

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.databaseexample.enitities.Klass
import com.example.databaseexample.enitities.Grade
import com.example.databaseexample.enitities.KlassWithStudents


@Dao
interface KlassDAO  {

    @Insert
    fun insertKlass(klass: Klass)

    @Delete
    fun deleteKlass(klass:Klass)

    @Query("SELECT * FROM klass_table")
    fun getAll(): LiveData<List<Klass>>

    @Transaction
    @Query("SELECT * FROM klass_table")
    fun getKlassWithStudents(klass: Klass): List<KlassWithStudents>

}

@Dao
interface GradeDAO  {

    @Insert
    fun insertGrade(grade: Grade)

    @Delete
    fun deleteGrade(grade: Grade)

    @Query("SELECT * FROM grade_table")
    fun getAll(): LiveData<List<Grade>>


}