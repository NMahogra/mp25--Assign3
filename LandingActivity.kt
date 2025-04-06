package com.example.tugas

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.app.User // Assuming User is in this package or adjust accordingly


class LandingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val user = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("USER_DATA", User::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("USER_DATA")
        }
        val welcomeTextView: TextView = findViewById(R.id.textViewWelcome)

        user?.let {
            welcomeTextView.text = "Welcome, ${it.name} to our app!"
        }
    }
}