package com.vendor.mastergarage.uidesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.vendor.mastergarage.R
import com.vendor.mastergarage.adapters.JobCardAdapter
import com.vendor.mastergarage.adapters.ThirteenAdapter
import com.vendor.mastergarage.databinding.ActivityJobCard2Binding
import com.vendor.mastergarage.databinding.ActivityThirteenBinding

class ThirteenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding  : ActivityThirteenBinding
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_thirteen)
        //setContentView(R.layout.activity_thirteen)
        val ListThirteen:List<Int> = listOf(R.drawable.car,R.drawable.car,R.drawable.car)
        binding.RVThirteen.adapter = ThirteenAdapter(ListThirteen)
        binding.RVThirteen.layoutManager = LinearLayoutManager(this)
    }
}