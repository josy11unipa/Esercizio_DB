package com.example.esercizio_db

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.esercizio_db.databinding.ActivityModBinding

class Mod_Activity:AppCompatActivity() {
    private lateinit var binding:ActivityModBinding
    private lateinit var dbManager:DBManager
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityModBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        dbManager= DBManager(this)
        dbManager.open()
        binding.updateButton.setOnClickListener{
            val lastId=binding.lastId
            val newName=binding.newName
            val newDesc=binding.NewDesc
            dbManager.update(lastId,newName,newDesc)
            val intent=Intent(this,MainActivity::class.java)
            intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TOP
            setResult(Activity.RESULT_OK,intent)
            startActivity(intent)

        }

    }
    override fun onDestroy() {
        dbManager.close()
        super.onDestroy()
    }
}