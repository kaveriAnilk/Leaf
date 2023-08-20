package com.example.finance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import java.io.File

class pin_verification_2 : AppCompatActivity() {

    lateinit var pin : EditText
    lateinit var submit : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin_verification2)

        pin = findViewById(R.id.edt_pin)
        submit = findViewById(R.id.submit)

        val fileName = "Pin.txt"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        val file = File(storageDir, fileName)
        val gotpin = file.readText()

        submit.setOnClickListener {
            val enteredpin = pin.text.toString()
            if(enteredpin != gotpin)
            {
                val show = Toast.makeText(this, "Pin is Incorrect", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@pin_verification_2,pin_verfication::class.java)
                startActivity(intent)
            }
            else
            {
                val show = Toast.makeText(this, "Pin set Successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@pin_verification_2,MainActivity::class.java)
                startActivity(intent)
            }

        }

    }
}