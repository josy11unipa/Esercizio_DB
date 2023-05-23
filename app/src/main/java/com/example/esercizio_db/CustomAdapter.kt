package com.example.esercizio_db

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.esercizio_db.databinding.CardViewBinding

class CustomAdapter(private val data:Array<String>) :RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(binding:CardViewBinding):RecyclerView.ViewHolder(binding.root) {
        val textID=binding.id
        val textName=binding.name
        val textDesc=binding.description

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}

