package com.example.android3_mvvmlivedata.ui.fragments.sign_up

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android3_mvvmlivedata.databinding.FragmentSignUpBinding
import com.example.android3_mvvmlivedata.preferences.PreferenceHelperBoolean

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

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
        transition()
    }

    private fun transition() {
            PreferenceHelperBoolean.showSignUp = true
        }
}