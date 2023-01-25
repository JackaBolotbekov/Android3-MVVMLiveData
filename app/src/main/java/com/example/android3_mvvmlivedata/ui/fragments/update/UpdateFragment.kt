package com.example.android3_mvvmlivedata.ui.fragments.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android3_mvvmlivedata.R
import com.example.android3_mvvmlivedata.databinding.FragmentUpdateBinding

class UpdateFragment : Fragment() {

    private lateinit var binding: FragmentUpdateBinding
    private val viewModel by viewModels<UpdateViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpdateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        setUpListener()
    }

    private fun getData() = with(binding) {
        viewModel.getData().observe(viewLifecycleOwner) { info ->
            etUpdateUsername.setText(info.username)
            etUpdateAge.setText(info.age.toString())
            etUpdateEmail.setText(info.email)
            etUpdatePassword.setText(info.password)
        }
    }

    private fun setUpListener() = with(binding) {
        btnUpdate.setOnClickListener {
        val username = etUpdateUsername.text.toString().trim()
        val age = etUpdateAge.text.toString().trim()
        val email = etUpdateEmail.text.toString().trim()
        val password = etUpdatePassword.text.toString().trim()

        if (username.isEmpty()){
            etUpdateUsername.error = "Введи имя"
        }
        else if (age.isEmpty()){
            etUpdateAge.error = "Введи возраст"
        }
        else if (email.isEmpty()){
            etUpdateEmail.error = "Введи Email"
        }
        else if (username.isEmpty()){
            etUpdatePassword.error = "Введи пароль"}
        else {
            viewModel.updateUserInfo(username, age.toInt(), email, password)
            findNavController().navigateUp()
           }
        }
    }
}