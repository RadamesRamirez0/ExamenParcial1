package com.example.parcial1.activities.main


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.parcial1.R
import com.example.parcial1.activities.ResultActivity



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val user = intent.getStringExtra("user")


        val arrayAns = Array(3){arrayOf("")}
        var arrayQuestions = Array(3){""}
        arrayQuestions = resources.getStringArray(R.array.Questions)
        arrayAns[0] = resources.getStringArray(R.array.Ans1)
        arrayAns[1] = resources.getStringArray(R.array.Ans2)
        arrayAns[2] = resources.getStringArray(R.array.Ans3)

        val txvCount = findViewById<TextView>(R.id.txvCount)
        val txvQuestion = findViewById<TextView>(R.id.txvQuestion)
        val btnAns1 = findViewById<Button>(R.id.btnAns1)
        val btnAns2 = findViewById<Button>(R.id.btnAns2)
        val btnAns3 = findViewById<Button>(R.id.btnAns3)

        var points = 0
        var i = 0

        fun showScore(points:Int)
        {
            val intent = Intent(this, ResultActivity::class.java).apply{
                putExtra("points",points.toString())
                putExtra("user", user)
            }

            startActivity(intent)
            finish()
        }
        fun setQuestAns(i:Int){
            if(i > 2)
                showScore(points)
            else
            {
                txvCount.text = (i+1).toString() + " / 3"
                txvQuestion.text = arrayQuestions[i]
                btnAns1.text = arrayAns[i][0]
                btnAns2.text = arrayAns[i][1]
                btnAns3.text = arrayAns[i][2]
            }

        }

        setQuestAns(i)


        btnAns1.setOnClickListener(){
            if(i == 0)
                points++

            i++
            setQuestAns(i)

        }
        btnAns2.setOnClickListener(){
            if(i == 2)
                points++
            i++
            setQuestAns(i)
        }
        btnAns3.setOnClickListener(){
            if(i ==1)
                points++
            i++
            setQuestAns(i)
        }





    }

}