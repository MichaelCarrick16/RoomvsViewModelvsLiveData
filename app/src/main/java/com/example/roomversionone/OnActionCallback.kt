package com.example.roomversionone

import com.example.roomversionone.db.UserEntity

interface OnActionCallback {
    fun onCallback(userEntity: UserEntity)
}