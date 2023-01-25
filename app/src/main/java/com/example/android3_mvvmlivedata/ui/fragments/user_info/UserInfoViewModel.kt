package com.example.android3_mvvmlivedata.ui.fragments.user_info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3_mvvmlivedata.App
import com.example.android3_mvvmlivedata.model.UserModel

class UserInfoViewModel : ViewModel() {

    private val _userLiveData = MutableLiveData<UserModel>()
    val userLiveData: LiveData<UserModel> = _userLiveData

    fun getUserInfo(): LiveData<UserModel>{
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

}