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
import com.udacity.shoestore.databinding.WelcomeFragmentBinding


class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: WelcomeFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.welcome_fragment, container, false
        )

        binding.welcomeBack.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
        }

        binding.welcomeNext.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_welcomeFragment_to_instructionFragment)
        }


        return binding.root
    }
}