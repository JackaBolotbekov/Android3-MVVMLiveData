package com.example.android3_mvvmlivedata.ui.fragments.sign_up

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android3_mvvmlivedata.R
import com.example.android3_mvvmlivedata.databinding.FragmentSignUpBinding
import com.example.android3_mvvmlivedata.data.local.preferences.PreferenceHelperBoolean

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private val viewModel by viewModels<SignUpViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        PreferenceHelperBoolean.unit(requireContext())
        setUpListener()
        transition()
    }

    private fun setUpListener() = with(binding) {
        btnAdd.setOnClickListener {
            val username = etSignUsername.text.toString().trim()
            val age = etSignAge.text.toString().trim()
            val email = etSignUsername.text.toString().trim()
            val password = etSignUsername.text.toString().trim()

            if (username.isEmpty()){
                etSignUsername.error = "Введи имя"
            }
            else if (age.isEmpty()){
                etSignAge.error = "Введи возраст"
            }
            else if (email.isEmpty()){
                etSignEmail.error = "Введи Email"
            }
            else if (username.isEmpty()){
                etSignPassword.error = "Введи пароль"}
            else{
                viewModel.signUp(username, age.toInt(), email, password)
                findNavController().navigate(R.id.action_signUpFragment_to_mainFragment2)
            }
        }
    }

    private fun transition() = with(PreferenceHelperBoolean) {
            showSignUp = true
        }
}