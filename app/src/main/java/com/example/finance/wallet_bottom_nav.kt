package com.example.finance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.text.Editable
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import org.w3c.dom.Text
import java.io.File

class wallet_bottom_nav : AppCompatActivity() {
    lateinit var showBalance : TextView
    lateinit var home : ImageButton
    lateinit var wallet : ImageButton
    lateinit var profile : ImageButton
    lateinit var add_money : EditText
    lateinit var proceedtoadd : ImageButton
    lateinit var spend : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)

        home = findViewById(R.id.home)
        wallet = findViewById(R.id.wallet)
        profile = findViewById(R.id.profile)
        add_money = findViewById(R.id.add_money_edt)
        proceedtoadd = findViewById(R.id.proceed_to_add)
        spend = findViewById(R.id.spend_analytics)
        showBalance = findViewById(R.id.balance)

        home.setOnClickListener {
            home()
        }

        profile.setOnClickListener {
            profile()
        }

        val fileName = "Balance.txt"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        val file = File(storageDir, fileName)

        if(!file.exists())
        {
            file.createNewFile()
        }

        var old_balance = file.readText()
        if(old_balance.isEmpty())
        {
            old_balance = 0.toString()
        }
        showBalance.setText( "Rs " +old_balance.toString())

        proceedtoadd.setOnClickListener {

            var update = add_money.text.toString().toInt()
            var new_balance = old_balance.toInt() + update
            file.writeText(new_balance.toString())
            add_money.text.clear()
            old_balance = file.readText()
            showBalance.setText("Rs $old_balance")

        }



    }

    fun home()
    {
        val intent = Intent(this@wallet_bottom_nav,home_bottom_nav::class.java)
        startActivity(intent)
    }
    fun profile()
    {
        val intent = Intent(this@wallet_bottom_nav,profile_bottom_nav::class.java)
        startActivity(intent)
    }
}

