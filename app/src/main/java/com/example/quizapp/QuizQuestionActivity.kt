package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity() , View.OnClickListener{

    private var mCurrentPosition:Int = 1
    private var mQuestionList:ArrayList<Question>? = null
    private var mSelectedOption : Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    private lateinit var  tv_question: TextView
    private lateinit var  tv_option_one: TextView
    private lateinit var  tv_option_two: TextView
    private lateinit var  tv_option_three: TextView
    private lateinit var  tv_option_four: TextView
    private lateinit var  tv_progress: TextView
    private lateinit var iv_image: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var btn_submit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

         tv_question = findViewById(R.id.tv_question)
         tv_option_one = findViewById(R.id.option_one)
         tv_option_two = findViewById(R.id.option_two)
         tv_option_three = findViewById(R.id.option_three)
         tv_option_four = findViewById(R.id.option_four)
         tv_progress = findViewById(R.id.tv_progress)
         iv_image = findViewById(R.id.iv_image)
         progressBar  = findViewById(R.id.progressBar)
         btn_submit = findViewById(R.id.btn_submit)

        mQuestionList = Constants.getQuestions()
        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)



    }

    private fun setQuestion(){
        val question = mQuestionList!![mCurrentPosition -1]

        defaultOptionsView()
        if (mCurrentPosition == mQuestionList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }
        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        tv_question.text = question.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for(option in options){
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.btn_submit -> {
                if (mSelectedOption == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                        }else->{
                        val intent = Intent(this,ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                        startActivity(intent)
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if (question!!.correctAnswer != mSelectedOption){
                        answerView(mSelectedOption, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
                    if (mCurrentPosition == mQuestionList!!.size ){
                        btn_submit.text = "FINISH"
                    }else{
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOption = 0
                }
            }
        }
    }
    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }
    private fun selectedOptionView(tv: TextView, selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOption = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363a63"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
}