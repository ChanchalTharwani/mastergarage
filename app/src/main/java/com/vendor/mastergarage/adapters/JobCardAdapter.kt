package com.vendor.mastergarage.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vendor.mastergarage.R
import com.vendor.mastergarage.databinding.ItemViewJobCardBinding

class JobCardAdapter(var List:List<String>): RecyclerView.Adapter<JobCardAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from((parent.context))
        val view = inflater.inflate(R.layout.item_view_job_card,parent,false)
        val a = ItemViewJobCardBinding.bind(view)

        return MyViewHolder(a)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.binding.data = List[position]
//     holder.button.setOnClickListener {
//         startActivity(Intent(this, MainActivity ::class.java))
//
//     }

    }

    override fun getItemCount(): Int {
        return List.size
    }

    class MyViewHolder( val binding:ItemViewJobCardBinding): RecyclerView.ViewHolder(binding.root){
//    var button = itemView.findViewById<TextView>(R.id.btn1)

    }


}