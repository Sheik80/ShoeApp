package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeDetailViewModel
import kotlinx.android.synthetic.main.shoe_detail_fragment.*
import kotlinx.android.synthetic.main.shoe_list_fragment.*
import timber.log.Timber


class ShoeListFragment : Fragment() {


    private lateinit var binding: ShoeListFragmentBinding
    private lateinit var viewModel: ShoeDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_list_fragment, container, false
        )

        //viewModel = ViewModelProvider(requireActivity()).get(com.udacity.shoestore.models.ShoeDetailViewModel::class.java)
        viewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)
        binding.shoeDetailViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.shoeListDetails.observe(this.viewLifecycleOwner, Observer { shoes ->
            //binding.shoeListFragmentLayout.removeAllViews()
            shoes.forEach { shoe ->
                Timber.i("ShoeDetailViewModel")
                //view.shoeList.addView(shoe.name)
                shoe.name
                shoe.size
                shoe.company
                shoe.description

            }
            val shoeLayout: android.widget.LinearLayout = binding.shoeListFragmentLayout
            val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            val shoeItemTextView: TextView =
                TextView(requireContext()).apply {
                    layoutParams = lp
                }

            shoeItemTextView.text = "${shoes}"
            binding.shoeListFragmentLayout.addView(shoeItemTextView)

        })

        /* binding.shoeListFragmentLayout.removeAllViews()
        shoeDetailSave.forEach{shoe ->
            shoe.name,
            shoe.description,
            shoe.company,
            shoe.size
        }*/





        binding.backShoeList.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_instructionFragment)
        }

        binding.fabShoeListFragment.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)


        }
        setHasOptionsMenu(true)
        return binding.root

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.nav_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        )
                || super.onOptionsItemSelected(item)
    }
}