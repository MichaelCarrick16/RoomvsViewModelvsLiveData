package com.example.roomversionone.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userinfo")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val name : String ,
    val email : String
)