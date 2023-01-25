package com.example.android3_mvvmlivedata.data.local.preferences

import android.content.Context
import android.content.SharedPreferences

class UserPreferenceHelper(context: Context) {

    private val sharedPreference: SharedPreferences =
        context.getSharedPreferences("sign-up", Context.MODE_PRIVATE)

    var username: String?
        get() = sharedPreference.getString("username", "")
        set(value) = sharedPreference.edit().putString("username", value).apply()

    var age: Int
        get() = sharedPreference.getInt("age", 0)
        set(value) = sharedPreference.edit().putInt("age", value).apply()

    var email: String?
        get() = sharedPreference.getString("email", "")
        set(value) = sharedPreference.edit().putString("email", value).apply()

    var password: String?
        get() = sharedPreference.getString("password", "")
        set(value) = sharedPreference.edit().putString("password", value).apply()
}