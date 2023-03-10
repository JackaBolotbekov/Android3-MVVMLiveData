package com.example.android3_mvvmlivedata.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.android3_mvvmlivedata.R
import com.example.android3_mvvmlivedata.databinding.ActivityMainBinding
import com.example.android3_mvvmlivedata.data.local.preferences.PreferenceHelperBoolean

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        when (PreferenceHelperBoolean.showSignUp) {
            true -> {
                navController.navigate(R.id.mainFragment)
            }
            else -> {
                navController.navigate(R.id.signUpFragment)
            }
        }
    }
}