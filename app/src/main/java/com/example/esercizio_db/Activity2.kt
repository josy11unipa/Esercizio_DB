package com.example.esercizio_db

import android.app.Activity
import android.content.Intent
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
        dbManager= DBManager(this)
        dbManager.open()
        binding.confirmNewAdd.setOnClickListener{
            val subject=binding.nameNewAdd.text.toString()
            val desc=binding.descNewAdd.text.toString()
            dbManager.insert(subject,desc)
            val intent=Intent(this,MainActivity::class.java)
            intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TOP
            setResult(Activity.RESULT_OK,intent)
            startActivity(intent)


        }

    }
     fun OnDestroy(){
        dbManager.close()
        super.onDestroy()
    }

}