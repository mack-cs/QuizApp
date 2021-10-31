package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var  tv_name: TextView
    private lateinit var  tv_score: TextView
    private lateinit var  btn_finish: Button
    private lateinit var  iv_trophy: ImageView
    private lateinit var  tv_congratulations: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_result)
      tv_name = findViewById(R.id.tv_name)
        tv_score = findViewById(R.id.tv_score)
      btn_finish = findViewById(R.id.btn_finish)
        iv_trophy = findViewById(R.id.iv_image_winner)
        tv_congratulations = findViewById(R.id.tv_congratulations)


      val username = intent.getStringExtra(Constants.USER_NAME)
       tv_name.text = username
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
       val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        Log.i("Res","$totalQuestions and $correctAnswers")
        var totalPercentage:Int = (correctAnswers/totalQuestions) * 100
        if(totalPercentage > 50){
            iv_trophy.setImageResource(R.drawable.ic_winner)
            tv_congratulations.text = "Congratulations"
        }else{
            iv_trophy.setImageResource(R.drawable.ic_failed)
            tv_congratulations.text = "Sorry, revise your colors"
        }
    tv_score.text = "Your score is $correctAnswers out of $totalQuestions"
        btn_finish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}