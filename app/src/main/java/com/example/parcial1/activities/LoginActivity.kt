package com.example.parcial1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.parcial1.R
import com.example.parcial1.activities.main.MainActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val edtUserName = findViewById<EditText>(R.id.edtUserName)
        val btnLoginStart = findViewById<Button>(R.id.btnLoginStart)
        val txvError = findViewById<TextView>(R.id.txvError)





        btnLoginStart.setOnClickListener(){


            val intent = Intent(this, MainActivity::class.java).apply{
                putExtra("user", edtUserName.text.toString())
            }
            if(edtUserName.text.isEmpty())
            {
                txvError.text = getString(R.string.txvError)
            }
            else
            {

                startActivity(intent)
                finish()

            }

        }
    }
}

