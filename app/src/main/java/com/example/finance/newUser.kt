package com.example.finance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import java.io.File
import android.os.Environment

class newUser : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var submit: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)

        name = findViewById(R.id.edt_name)
        submit = findViewById(R.id.submit_button)

        // Directory and File
        val fileName = "USER.txt"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        val file = File(storageDir, fileName)

        //only for checking purpose
        val filePin = "Pin.txt"
        val storageDir2 = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        val filepin = File(storageDir, filePin)

        if (!file.exists() || file.readText().isEmpty()) {
            file.createNewFile()
        }
        else {

            if(!filepin.exists() || filepin.readText().isEmpty())
                {
                    val intent = Intent(this@newUser, pin_verfication::class.java)
                    startActivity(intent)
                }
            else
            {
                val intent = Intent(this@newUser, check_pin::class.java)
                startActivity(intent)
                finish() // Finish current activity
            }

        }

        // Submit button
        submit.setOnClickListener {
            val nameOfUser = name.text.toString().trim()
            file.writeText(nameOfUser)
            val intent = Intent(this@newUser, pin_verfication::class.java)
            startActivity(intent)
            }
        }
    }
