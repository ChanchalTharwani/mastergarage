package com.vendor.mastergarage.uidesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.vendor.mastergarage.R
import com.vendor.mastergarage.adapters.JobCardAdapter
import com.vendor.mastergarage.databinding.ActivityJobCard2Binding

class JobCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
         lateinit var binding  : ActivityJobCard2Binding
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_job_card2)
            //setContentView(R.layout.activity_job_card2)
        val List:List<String> = listOf("Body Damages & Fuel","Demanded Jobs","Recommended Jobs","Inventory Checklist","Service Instructions")
        binding.RVOne.adapter = JobCardAdapter(List)
        binding.RVOne.layoutManager = LinearLayoutManager(this)
    }
}