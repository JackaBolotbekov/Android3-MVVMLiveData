package com.example.android3_mvvmlivedata.ui.fragments.user_info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3_mvvmlivedata.App
import com.example.android3_mvvmlivedata.data.model.UserModel
import com.example.android3_mvvmlivedata.data.repository.UserRepository

class UserInfoViewModel : ViewModel() {

    private val repository = UserRepository()
    private val _userLiveData = MutableLiveData<UserModel>()
    val userLiveData: LiveData<UserModel> = _userLiveData

    fun getUserInfo(){
        _userLiveData.value = repository.getUserInfo()
    }
}