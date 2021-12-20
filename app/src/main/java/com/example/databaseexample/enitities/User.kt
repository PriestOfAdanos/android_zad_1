package com.example.databaseexample.enitities

import androidx.room.*
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="userID",index = true)
    var userID: Long=0L,
    @ColumnInfo(name="first_name")
    var FirstName:String,
    @ColumnInfo(name="last_name")
    var LastName:String,
    @ColumnInfo(name="age")
    var Age:Int
)



@Entity(tableName = "klass_table")
data class Klass(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="klassID",index = true)
    var klassID: Long=0L,
    @ColumnInfo(name="klass_name")
    var KlassName:String,
    @ColumnInfo(name="klass_start")
    var KlassStart:String,
    @ColumnInfo(name="klass_end")
    var KlassEnd:String,
    )

@Entity(tableName = "grade_table")
data class Grade(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="gradeID",index = true)
    var gradeID: Long=0L,
    @ColumnInfo(name="first_name")
    var gradeValue:String
)



@Entity(primaryKeys = ["klassID", "userID"])
data class KlassUserRef(
    val klassID: Long,
    val userID: Long
)

@Entity(primaryKeys = ["userID","gradeID"])
data class UserGradeRef(
    val userID: Long,
    val gradeID: Long
    )

@Entity(primaryKeys = ["klassID","gradeID"])
data class KlassGradeRef(
    val klassID: Long,
    val gradeID: Long
)


data class KlassWithStudents (
    @Embedded
    val klass: Klass,
    @Relation(
        parentColumn = "klassID",
        entity = User::class,
        entityColumn = "userID",
        associateBy = Junction(
            value = KlassUserRef::class,
            parentColumn = "klassID",
            entityColumn = "userID"
        )
    )
    val users: List<User>
)

//data class KlassWithStudents(
//    @Embedded val klass: Klass,
//    @Relation(
//        parentColumn = "klassID",
//        entityColumn = "userID",
//        associateBy = Junction(KlassUserRef::class)
//    )
//    val user: List<User>
//)

//data class StudentWithKlasses(
//    @Embedded val user: User,
//    @Relation(
//        parentColumn = "userID",
//        entityColumn = "klassID",
//        associateBy = Junction(KlassUserRef::class)
//    )
//    val klass: List<Klass>
//)
//
//data class StudentWithGrades(
//    @Embedded val user: User,
//    @Relation(
//        parentColumn = "userID",
//        entityColumn = "gradeID",
//        associateBy = Junction(UserGradeRef::class)
//    )
//    val grad: List<Grade>
//)
//data class KlassWithGrades(
//    @Embedded val klass: Klass,
//    @Relation(
//        parentColumn = "klassID",
//        entityColumn = "gradeID",
//        associateBy = Junction(KlassGradeRef::class)
//    )
//    val grad: List<Grade>
//)

