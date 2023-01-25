package com.example.android3_mvvmlivedata.ui.fragments.user_info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.android3_mvvmlivedata.R
import com.example.android3_mvvmlivedata.databinding.FragmentMainBinding

class UserInfoFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel by viewModels<UserInfoViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListener()
    }

    private fun setUpListener() = with(binding) {
        viewModel.getUserInfo()
        viewModel.userLiveData.observe(viewLifecycleOwner){ info ->
            tvUsername.text = info.username
            tvAge.text = info.age.toString()
            tvEmail.text = info.email
            tvPassword.text = info.password
        }
        fabUpdate.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_updateFragment)
        }
    }
}