package com.example.esercizio_db

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; questo aggiunge elementi alla barra delle azioni se è presente.
        val inflater:MenuInflater=menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }
}