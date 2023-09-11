package com.example.finance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Profile : AppCompatActivity() {

    private val protectedField: Any? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }
}
