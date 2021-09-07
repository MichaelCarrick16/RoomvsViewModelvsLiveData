package com.example.roomversionone

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomversionone.db.RoomAppDb
import com.example.roomversionone.db.UserEntity

class MainViewModel : ViewModel() {
    private lateinit var context: Context
    lateinit var list : List<UserEntity>

    val listUser : MutableLiveData<List<UserEntity>> by lazy {
        MutableLiveData<List<UserEntity>>()
    }

    fun setContext(context: Context){
        this.context = context
        this.list = RoomAppDb.getAppDatabase(context).userDao().getAllUserInfo()
    }

    fun getAllUser() {
       listUser.value = RoomAppDb.getAppDatabase(context).userDao().getAllUserInfo()
    }

    fun insertUser(userEntity: UserEntity){
        RoomAppDb.getAppDatabase(context).userDao().insertUser(userEntity)
        getAllUser()
    }

    fun deleteUser(userEntity: UserEntity){
        RoomAppDb.getAppDatabase(context).userDao().deleteUser(userEntity)
        getAllUser()
    }
}