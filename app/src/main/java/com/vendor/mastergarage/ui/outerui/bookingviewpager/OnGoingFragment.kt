package com.vendor.mastergarage.ui.outerui.bookingviewpager

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vendor.mastergarage.adapters.OnGoingAdapter
import com.vendor.mastergarage.constraints.Constraints
import com.vendor.mastergarage.databinding.FragmentOnGoingBinding
import com.vendor.mastergarage.model.OnGoingDataItem
import com.vendor.mastergarage.model.ResultItem
import com.vendor.mastergarage.networkcall.Response
import com.vendor.mastergarage.ui.login.LoginViewModel
import com.vendor.mastergarage.ui.outerui.VehicleDetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnGoingFragment : Fragment() {

    lateinit var binding: FragmentOnGoingBinding

   // private val viewModel: OnGoingViewModel by viewModels()
    private val viewModel: LoginViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnGoingBinding.inflate(inflater, container, false)


        viewModel.ongoingData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Response.Loading -> {

                }

                is Response.Success -> {
                    binding.recyclerView.adapter = OnGoingAdapter(it.data!!.result)
                    binding.recyclerView.layoutManager =LinearLayoutManager(requireActivity())

                }
                is Response.Failure -> {
                    Log.e(TAG, it.errorMessage.toString())
                }
            }
        })


        return binding.root
    }

    companion object {
        private const val TAG = "OnGoingFragment"

    }

    override fun onResume() {
        super.onResume()
        val Preferences:SharedPreferences  = this.requireActivity().getSharedPreferences("my_db", Context.MODE_PRIVATE)

      //  val sharedprefget:SharedPreferences
        viewModel.ongoing( Preferences.getString("vendorId","1")!!.toInt())

    }



}