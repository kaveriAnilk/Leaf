package com.example.finance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var pay : ImageButton
    lateinit var recieve : ImageButton
    lateinit var split : ImageButton
    lateinit var home : ImageButton
    lateinit var wallet : ImageButton
    lateinit var profile : ImageButton
    lateinit var last_transaction : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pay = findViewById(R.id.pay)
        recieve = findViewById(R.id.recieve)
        split = findViewById(R.id.split)
        home = findViewById(R.id.home)
        wallet = findViewById(R.id.wallet)
        profile = findViewById(R.id.profile)
        last_transaction = findViewById(R.id.last_transaction)
    }
}