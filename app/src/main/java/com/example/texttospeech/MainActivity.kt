package com.example.texttospeech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val btn:Button = findViewById(R.id.button)
        btn.setOnClickListener {
            val intent = Intent(this,ActivityPage::class.java)
            startActivity(intent)
        }
    }
}