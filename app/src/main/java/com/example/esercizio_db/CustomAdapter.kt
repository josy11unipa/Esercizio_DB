package com.example.esercizio_db

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.esercizio_db.databinding.CardViewBinding

class CustomAdapter(private val cursor:Cursor) :RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(binding:CardViewBinding):RecyclerView.ViewHolder(binding.root) {
        val textID=binding.id
        val textName=binding.name
        val textDesc=binding.description

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=CardViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
      return cursor.count
    }

    @SuppressLint("Range")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(cursor.moveToPosition(position)){
            holder.textID.text=cursor.getLong(cursor.getColumnIndex(DbHelper.ID)).toString()
            holder.textName.text=cursor.getString(cursor.getColumnIndex(DbHelper.SUBJECT))
            holder.textDesc.text=cursor.getString(cursor.getColumnIndex(DbHelper.DESC))
            holder.itemView.setOnClickListener{
                val intent= Intent(holder.itemView.context,Mod_Activity::class.java)
                intent.putExtra("idKey",holder.textID.text.toString())
                holder.itemView.context.startActivity(intent)

            }

        }
    }


}

