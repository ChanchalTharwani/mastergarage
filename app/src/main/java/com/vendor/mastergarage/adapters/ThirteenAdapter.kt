package com.vendor.mastergarage.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vendor.mastergarage.R
import com.vendor.mastergarage.databinding.ItemViewJobCardBinding
import com.vendor.mastergarage.databinding.ItemViewThirteenBinding

class ThirteenAdapter(var ListThirteen:List<Int>): RecyclerView.Adapter<ThirteenAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from((parent.context))
        val view = inflater.inflate(R.layout.item_view_thirteen,parent,false)
        val a = ItemViewThirteenBinding.bind(view)

        return MyViewHolder(a)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.binding.imgcar.setImageResource(ListThirteen[position])
//     holder.button.setOnClickListener {
//         startActivity(Intent(this, MainActivity ::class.java))
//
//     }

    }

    override fun getItemCount(): Int {
        return ListThirteen.size
    }

    class MyViewHolder( val binding: ItemViewThirteenBinding): RecyclerView.ViewHolder(binding.root){
//    var button = itemView.findViewById<TextView>(R.id.btn1)

    }


}