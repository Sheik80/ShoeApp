package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeDetailViewModel
import timber.log.Timber


class ShoeDetailFragment : Fragment() {

    private lateinit var binding: ShoeDetailFragmentBinding
    private lateinit var viewModel: ShoeDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_detail_fragment, container, false
        )
       // viewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeDetailViewModel::class.java)
        binding.shoeDetailViewModel = viewModel
        binding.lifecycleOwner = this


        binding.shoeDetailCancel.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

       /* viewModel.shoeAdd.observe(this, Observer { hasFinished ->

            if (hasFinished) {

                shoeAddFinish()
                viewModel.onChooseComplete()
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
            }

        }

        )*/
        binding.shoeDetailSave.setOnClickListener {
            viewModel.onSaveDetail()
            Timber.i("ShoeDetailOnSaveCalled")
            //if (hasFinished) {

                //shoeAddFinish()
                //viewModel.onChooseComplete()
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
            //}

        }
        // Inflate the layout for this fragment
        return binding.root
    }

   /* private fun shoeAddFinish() {
        val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        view?.findNavController()?.navigate(action)
        Toast.makeText(this.activity, "Add Finished", Toast.LENGTH_SHORT).show()
    }*/


}