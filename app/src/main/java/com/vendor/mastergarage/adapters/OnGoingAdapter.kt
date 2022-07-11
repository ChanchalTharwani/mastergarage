package com.vendor.mastergarage.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vendor.mastergarage.R
import com.vendor.mastergarage.databinding.LayoutOngoingBinding
import com.vendor.mastergarage.model.OnGoingDataItem
import com.vendor.mastergarage.model.OngoingResponseModel
import com.vendor.mastergarage.model.ResultItem
import com.vendor.mastergarage.utlis.assetsToBitmapModel
import com.vendor.mastergarage.utlis.calculateMoney


class OnGoingAdapter(var listOngoing:ArrayList<ResultItem>):RecyclerView.Adapter<OnGoingAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from((parent.context))
        val view = inflater.inflate(R.layout.layout_ongoing, parent, false)
        val a = LayoutOngoingBinding.bind(view)

        return MyViewHolder(a)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // holder.Binding.bKTime.text = "${leadItem.bookingDate} at ${leadItem.bookingTime}"
        holder.binding.carName.text = listOngoing[position].manufacturerName
        holder.binding.carFuelType.text = listOngoing[position].fuelType
        holder.binding.bKTime.text = listOngoing[position].bookingTime
        holder.binding.pKTime.text = listOngoing[position].appointmentTime


    }


    //holder.binding = listOngoing[position]
//     holder.button.setOnClickListener {
//         startActivity(Intent(this, MainActivity ::class.java))
//


    override fun getItemCount(): Int {
        return listOngoing.size
    }

    class MyViewHolder(val binding: LayoutOngoingBinding) : RecyclerView.ViewHolder(binding.root) {
//    var button = itemView.findViewById<TextView>(R.id.btn1)


    }
}