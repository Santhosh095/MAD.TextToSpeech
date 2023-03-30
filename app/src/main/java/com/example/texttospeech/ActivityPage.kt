package com.example.texttospeech

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class ActivityPage : AppCompatActivity(), TextToSpeech.OnInitListener {
    private lateinit var etspeak : EditText
    private lateinit var btspeak : Button
    private lateinit var tts : TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)
        supportActionBar?.hide()
        etspeak=findViewById(R.id.txt_box)
        btspeak=findViewById(R.id.txt_btn)
        btspeak.isEnabled=false
        tts=TextToSpeech(this,this)

        btspeak.setOnClickListener {speakOut() }

        val reset:TextView = findViewById(R.id.textView2)

        reset.setOnClickListener {
            etspeak.text = null
        }
    }

    private fun speakOut() {
        val text =etspeak.text.toString()
        tts.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }

    override fun onInit(status: Int) {
        if (status==TextToSpeech.SUCCESS) {
            val result = tts.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {
            }
            else{
                btspeak.isEnabled=true
            }
        }
    }
}