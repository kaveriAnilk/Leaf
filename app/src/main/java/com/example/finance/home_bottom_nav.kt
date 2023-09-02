package com.example.finance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class home_bottom_nav : AppCompatActivity() {
    lateinit var pay : ImageButton
    lateinit var recieve : ImageButton
    lateinit var split : ImageButton
    lateinit var home : ImageButton
    lateinit var wallet : ImageButton
    lateinit var profile : ImageButton
    lateinit var last_transaction : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        pay = findViewById(R.id.pay)
        recieve = findViewById(R.id.recieve)
        split = findViewById(R.id.split)
        home = findViewById(R.id.home)
        wallet = findViewById(R.id.wallet)
        profile = findViewById(R.id.profile)
        last_transaction = findViewById(R.id.last_transaction)


        wallet.setOnClickListener {wallet() }
        profile.setOnClickListener {profile() }




        pay.setOnClickListener {

        }
    }
    fun wallet()
    {
        val intent = Intent(this@home_bottom_nav,wallet_bottom_nav::class.java)
        startActivity(intent)
    }
    fun profile()
    {
        val intent = Intent(this@home_bottom_nav,profile_bottom_nav::class.java)
        startActivity(intent)
    }
}