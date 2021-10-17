package com.example.mvvm2.ui.history

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm2.databinding.ItemHistoryBinding

class HistoryRecyclerAdapter(val historyClickListener: (String) -> Unit) :
    RecyclerView.Adapter<HistoryRecyclerAdapter.ViewHolder>() {

    private val histories:ArrayList<String> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryRecyclerAdapter.ViewHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryRecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(histories[position])
        holder.itemView.setOnClickListener { historyClickListener(histories[position])}
    }

    override fun getItemCount(): Int = histories.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(histories: ArrayList<String>) {
        this.histories.clear()
        this.histories.addAll(histories)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding:ItemHistoryBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(history:String) {
            binding.history = history
        }
    }

}