package com.example.finance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.EditText
import android.widget.ImageButton
import java.io.File

class pin_verfication : AppCompatActivity() {

    lateinit var pin : EditText
    lateinit var submit : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin_verfication)

        pin = findViewById(R.id.edt_pin)
        submit = findViewById(R.id.submit)

        val fileName = "Pin.txt"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        val file = File(storageDir, fileName)

        if(!file.exists())
        {
            file.createNewFile()
        }
        else
        {
            file.delete()
            file.createNewFile()
        }

        submit.setOnClickListener {
            val pinOfuser = pin.text.toString().trim()
            file.writeText(pinOfuser)

            val intent = Intent(this@pin_verfication,pin_verification_2::class.java)
            startActivity(intent)
        }

    }
}