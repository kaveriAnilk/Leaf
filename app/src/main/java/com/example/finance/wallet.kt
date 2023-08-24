package com.example.finance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView

class wallet : AppCompatActivity() {

    lateinit var pay : ImageButton
    lateinit var recieve : ImageButton
    lateinit var split : ImageButton
    lateinit var home : ImageButton
    lateinit var wallet : ImageButton
    lateinit var profile : ImageButton
    lateinit var add_money : EditText
    lateinit var proceedtoadd : ImageButton
    lateinit var spend : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)

        pay = findViewById(R.id.pay)
        recieve = findViewById(R.id.recieve)
        split = findViewById(R.id.split)
        home = findViewById(R.id.home)
        wallet = findViewById(R.id.wallet)
        profile = findViewById(R.id.profile)
        add_money = findViewById(R.id.add_money_edt)
        proceedtoadd = findViewById(R.id.proceed_to_add)
        spend = findViewById(R.id.spend_analytics)
    }
}