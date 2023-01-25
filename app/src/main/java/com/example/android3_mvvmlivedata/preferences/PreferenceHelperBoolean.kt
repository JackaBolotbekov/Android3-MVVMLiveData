package com.example.android3_mvvmlivedata.preferences

import android.content.Context
import android.content.SharedPreferences

object PreferenceHelperBoolean {

    private lateinit var sharedPreference: SharedPreferences

    fun unit(context: Context) {
        sharedPreference = context.getSharedPreferences("geek", Context.MODE_PRIVATE)
    }

    var showSignUp: Boolean
        get () = sharedPreference.getBoolean("tech", false)
        set (value) = sharedPreference.edit().putBoolean("tech", value).apply()
}