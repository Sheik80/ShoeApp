package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionFragmentBinding
import com.udacity.shoestore.databinding.WelcomeFragmentBinding


class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: InstructionFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.instruction_fragment, container, false
        )

        binding.instrBack.setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_instructionFragment_to_welcomeFragment)
            }
        binding.instrStart.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_instructionFragment_to_shoeListFragment2)

        }

        return binding.root
    }


}