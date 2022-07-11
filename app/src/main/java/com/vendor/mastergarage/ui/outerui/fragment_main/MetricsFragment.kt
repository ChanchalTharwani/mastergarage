package com.vendor.mastergarage.ui.outerui.fragment_main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.vendor.mastergarage.databinding.FragmentMetricsBinding
import com.vendor.mastergarage.ui.notifications.NotificationUi

class MetricsFragment : Fragment() {
    lateinit var binding: FragmentMetricsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMetricsBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment

        binding.notification.setOnClickListener {
            val bottomSheetFragment: BottomSheetDialogFragment = NotificationUi()
            bottomSheetFragment.show(childFragmentManager, NotificationUi.TAG)
        }


        return binding.root

    }
}