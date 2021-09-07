package com.example.roomversionone.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class],version = 1)
abstract class RoomAppDb : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object{
        private var instance : RoomAppDb? = null

        fun getAppDatabase(context: Context) : RoomAppDb{
            if(instance==null){
                instance = Room.databaseBuilder(context,RoomAppDb::class.java,"AppDB1")
                    .allowMainThreadQueries()
                    .build()
            }
            return instance as RoomAppDb
        }
    }

}