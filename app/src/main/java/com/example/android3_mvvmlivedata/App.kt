package com.example.android3_mvvmlivedata

import android.app.Application
import com.example.android3_mvvmlivedata.data.local.preferences.PreferenceHelperBoolean
import com.example.android3_mvvmlivedata.data.local.preferences.UserPreferenceHelper

class App : Application() {

    companion object {
        lateinit var userPreferenceHelper: UserPreferenceHelper
    }

    override fun onCreate() {
        super.onCreate()
        userPreferenceHelper = UserPreferenceHelper(applicationContext)
        PreferenceHelperBoolean.unit(this)
    }
}