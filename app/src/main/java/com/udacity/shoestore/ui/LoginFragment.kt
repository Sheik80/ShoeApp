package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding


class LoginFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: LoginFragmentBinding = DataBindingUtil.inflate(
            inflater,R.layout.login_fragment, container, false
        )

        binding.login.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)

        }

        binding.createAccount.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        // Inflate the layout for this fragment
        return binding.root
    }


}