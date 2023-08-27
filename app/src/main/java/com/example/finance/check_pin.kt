package com.example.finance

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.io.File

class check_pin : AppCompatActivity() {
    lateinit var pin : EditText
    lateinit var submit : ImageButton
    lateinit var name : TextView
    lateinit var forget_pin : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_pin)
        pin = findViewById(R.id.edt_pin)
        submit = findViewById(R.id.submit)
        name = findViewById(R.id.welcome_name)
        forget_pin = findViewById(R.id.forgot_pin)

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
                val intent = Intent(this@check_pin,home_bottom_nav::class.java)
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

        forget_pin.setOnClickListener {
            forgetpass1()
        }




    }

    fun forgetpass1()
    {
        var alertDialog = AlertDialog.Builder(this@check_pin)
        alertDialog.setTitle("Forget Pin")
            .setMessage("Caution : All the data of the user will be erased" +
                    " Do u want to continue")
            .setPositiveButton("Yes",DialogInterface.OnClickListener{
                    dialogInterface, which ->

                forgetpass2()

            })
            .show()
    }

    fun forgetpass2()
    {
        var alertDialog2 = AlertDialog.Builder(this@check_pin)
        alertDialog2.setTitle("Forget Pin")
            .setMessage("Caution : Do you really want to clear all the Data")
            .setPositiveButton("Confirm",DialogInterface.OnClickListener{
                    dialogInterface, which ->

                val fileName = "USER.txt"
                val storageDir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
                val file = File(storageDir, fileName)

                file.delete()

                val intent = Intent(this@check_pin,newUser::class.java)
                startActivity(intent)


            })
            .show()
    }
}