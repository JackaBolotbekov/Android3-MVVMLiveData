package com.example.android3_mvvmlivedata.ui.fragments.sign_up

import androidx.lifecycle.ViewModel
import com.example.android3_mvvmlivedata.App
import com.example.android3_mvvmlivedata.model.UserModel

class SignUpViewModel : ViewModel(){

    fun signUp (username: String, age: Int, email: String, password: String) {
        App.userPreferenceHelper.username = username
        App.userPreferenceHelper.age = age
        App.userPreferenceHelper.email = email
        App.userPreferenceHelper.password = password
    }

}