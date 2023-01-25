package com.example.android3_mvvmlivedata.data.repository

import com.example.android3_mvvmlivedata.App
import com.example.android3_mvvmlivedata.data.model.UserModel

class UserRepository {

    fun signUp(user: UserModel) {
        App.userPreferenceHelper.username = user.username
        App.userPreferenceHelper.age = user.age
        App.userPreferenceHelper.email = user.email
        App.userPreferenceHelper.password = user.password
    }

    // функция для получения первичных данных
    fun getUserInfo(): UserModel {
        App.userPreferenceHelper.apply {
            return UserModel(
                username = username,
                age = age,
                email = email,
                password = password
            )
        }
    }

    // функция для обновления первичных данных
    fun updateUserInfo(userModel: UserModel){
        App.userPreferenceHelper.apply {
            username = userModel.username
            age= userModel.age
            email = userModel.email
            password = userModel.password
        }
    }
}