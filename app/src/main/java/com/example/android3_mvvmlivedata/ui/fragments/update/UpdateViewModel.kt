package com.example.android3_mvvmlivedata.ui.fragments.update

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3_mvvmlivedata.App
import com.example.android3_mvvmlivedata.data.model.UserModel
import com.example.android3_mvvmlivedata.data.repository.UserRepository

class UpdateViewModel : ViewModel() {

    private val repository = UserRepository()
    private val _userLiveData = MutableLiveData<UserModel>()
    private val userLiveData: LiveData<UserModel> = _userLiveData

    fun getData(): LiveData<UserModel> {
        App.userPreferenceHelper.apply {
            _userLiveData.value = UserModel(
                username = username,
                age = age,
                email = email,
                password = password
            )
        }
        return userLiveData
    }

    fun updateUserInfo(username: String, age: Int, email: String, password: String) {
        repository.updateUserInfo(UserModel(username, age, email, password))
    }
}