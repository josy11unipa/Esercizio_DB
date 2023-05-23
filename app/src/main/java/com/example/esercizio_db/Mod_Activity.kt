package com.example.esercizio_db

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.esercizio_db.databinding.ActivityModBinding
import java.lang.NumberFormatException

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

            try {
                val lastId = binding.lastId.text.toString().toLong()
                val newName = binding.newName.text.toString()
                val newDesc = binding.NewDesc.text.toString()
                dbManager.update(lastId, newName, newDesc)
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                setResult(Activity.RESULT_OK, intent)
                startActivity(intent)
            }catch (e:NumberFormatException){
                Toast.makeText(this,"devi inserire un intero",Toast.LENGTH_SHORT).show()
            }

        }
        binding.deleteB.setOnClickListener{

            try {
                val id=binding.deleteId.text.toString().toLong()
                val n= dbManager.delete(id)
                Toast.makeText(this,"ho eliminato $n elementi",Toast.LENGTH_SHORT).show()
                val intent=Intent(this,MainActivity::class.java)
                intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TOP
                setResult(Activity.RESULT_OK,intent)
                startActivity(intent)

            }catch (e:NumberFormatException){
                Toast.makeText(this,"devi inserire un intero",Toast.LENGTH_SHORT).show()
            }




        }

    }
    override fun onDestroy() {
        dbManager.close()
        super.onDestroy()
    }
}