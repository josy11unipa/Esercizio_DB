package com.example.esercizio_db

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.esercizio_db.databinding.ActivityAddBinding

class Activity2:AppCompatActivity (){
    private lateinit var binding:ActivityAddBinding
    private lateinit var dbManager: DBManager
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityAddBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        dbManager=DBManager(this)
        dbManager.open()
    }
}