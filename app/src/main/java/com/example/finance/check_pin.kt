package com.example.finance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import java.io.File

class check_pin : AppCompatActivity() {
    lateinit var pin : EditText
    lateinit var submit : ImageButton
    lateinit var name : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_pin)
        pin = findViewById(R.id.edt_pin)
        submit = findViewById(R.id.submit)
        name = findViewById(R.id.welcome_name)

        //File for reference
        val fileName = "USER.txt"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        val file = File(storageDir, fileName)

        //only for checking purpose
        val filePin = "Pin.txt"
        val storageDir2 = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        val filepin = File(storageDir, filePin)

        submit.setOnClickListener {
            var pinfromuser = pin.text.toString()
            if(pinfromuser == filepin.readText().toString())
            {
                val intent = Intent(this@check_pin,MainActivity::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this, "Wrong Pin Entered", Toast.LENGTH_SHORT).show()
                pin.text.clear()
            }
        }

        //name

        var nameofuser = file.readText().toString()
        name.setText("Welcome, $nameofuser")

    }


}