package com.example.esercizio_db

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.esercizio_db.databinding.ActivityMainBinding
import com.example.esercizio_db.databinding.CardViewBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dbManager: DBManager
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dbManager = DBManager(this)
        dbManager.open()
        val cursor = dbManager.fetchAll()
        if (cursor.count != 0) {
            binding.recycler.layoutManager = LinearLayoutManager(this)
            binding.recycler.adapter = CustomAdapter(cursor)
        } else {
            Toast.makeText(this, "il database è vuoto", Toast.LENGTH_SHORT).show()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; questo aggiunge elementi alla barra delle azioni se è presente.
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.addB -> {
                val intent = Intent(this, Activity2::class.java)
                setResult(Activity.RESULT_OK, intent)
                startActivity(intent)

            }

        }
        return super.onOptionsItemSelected(item)
    }

}