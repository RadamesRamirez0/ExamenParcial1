package com.example.parcial1.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.parcial1.R
import com.example.parcial1.activities.main.MainActivity

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val txvUser = findViewById<TextView>(R.id.txvUser)
        val txvScore = findViewById<TextView>(R.id.txvScore)
        val btnPlayAgain = findViewById<Button>(R.id.btnPlayAgain)

        val user = intent.getStringExtra("user")
        val points = intent.getStringExtra("points")
        var score = txvScore.text.toString()
        score +=  " " + points
        txvUser.text = user
        txvScore.text = score

        btnPlayAgain.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java).apply{
                putExtra("user", user)
            }
            startActivity(intent)
            finish()
        }

    }
}