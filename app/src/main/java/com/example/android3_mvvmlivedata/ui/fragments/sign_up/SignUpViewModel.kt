package com.example.android3_mvvmlivedata.ui.fragments.sign_up

import androidx.lifecycle.ViewModel
import com.example.android3_mvvmlivedata.App
import com.example.android3_mvvmlivedata.data.model.UserModel
import com.example.android3_mvvmlivedata.data.repository.UserRepository

class SignUpViewModel : ViewModel(){

    private val repository = UserRepository()

    fun signUp (username: String, age: Int, email: String, password: String){
        repository.signUp(UserModel(username, age, email, password))
    }

}