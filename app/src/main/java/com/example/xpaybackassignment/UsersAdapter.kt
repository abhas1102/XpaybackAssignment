package com.example.xpaybackassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xpaybackassignment.clicklistener.ClickListener
import com.example.xpaybackassignment.databinding.ItemActivityMainBinding
import com.example.xpaybackassignment.model.User

class UsersAdapter(val users:List<User>, val clickListener: ClickListener):RecyclerView.Adapter<UsersAdapter.ViewHolder>() {
    class ViewHolder(private val binding:ItemActivityMainBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(data: User) {
            binding.userDetails = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemActivityMainBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])

        holder.itemView.setOnClickListener {
            clickListener.onClick(user = users.get(position))
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }


}