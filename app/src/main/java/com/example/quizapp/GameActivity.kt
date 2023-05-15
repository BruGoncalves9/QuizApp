package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.data.Question
import com.example.quizapp.data.getQuestions
import com.example.quizapp.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityGameBinding

    private var currentPosition: Int = 1 // Default and the first question position
    private var questions: ArrayList<Question> = getQuestions()
    private var correctAnswers: Int = 0
    private var username: String? = null
    private var answer: String? = null
    private var pressed: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Receives the username inserted
        username = intent.getStringExtra("username")

        // First question
        answer=setupQuestions()

        // Verifies everytime the pressed button
        optionClicked()
    }

    private fun setupQuestions(): String
    {
        val question: Question = questions!![currentPosition - 1] // Getting the question from the list with the help of current position.
        binding.progressBar.progress = currentPosition // Setting the current progress in the progressbar using the position of question
        binding.progress.text = "$currentPosition" + "/" + binding.progressBar.max // Setting up the progress text
        binding.question.text = question.question
        binding.option1.text = question.option1
        binding.option2.text = question.option2
        binding.option3.text = question.option3
        binding.option4.text = question.option4
        return question.correctAnswer
    }

    private fun optionClicked()
    {
        // Waits for an event to happen in any button/choice, blocks if it was already answered
        binding.option1.setOnClickListener {
            if(!pressed) {
                verifyAnswer(1, binding.option1.text.toString(), answer!!)
            }
        }

        binding.option2.setOnClickListener {
            if(!pressed) {
                verifyAnswer(2, binding.option2.text.toString(), answer!!)
            }
        }

        binding.option3.setOnClickListener {
            if(!pressed) {
                verifyAnswer(3, binding.option3.text.toString(), answer!!)
            }
        }

        binding.option4.setOnClickListener {
            if(!pressed) {
                verifyAnswer(4, binding.option4.text.toString(), answer!!)
            }
        }

        // This one is not blocked, because it is the "next" button
        binding.buttonNext.setOnClickListener {
            nextQuestion()
        }
    }

    private fun verifyAnswer(Id: Int, Selected: String, Answer: String)
    {
        var correct = false
        if(Selected==Answer)
        {
            correct = true
            correctAnswers++
        }
        else
        {
            correct=false
        }

        when (Id) {
            1 -> {
                if (correct)
                {
                    binding.option1.setBackgroundColor(Color.GREEN)
                }
                else
                {
                    binding.option1.setBackgroundColor(Color.RED)
                }
            }

            2 -> {
                if (correct)
                {
                    binding.option2.setBackgroundColor(Color.GREEN)
                }
                else
                {
                    binding.option2.setBackgroundColor(Color.RED)
                }
            }

            3 -> {
                if (correct)
                {
                    binding.option3.setBackgroundColor(Color.GREEN)
                }
                else
                {
                    binding.option3.setBackgroundColor(Color.RED)
                }
            }

            else -> {
                if (correct)
                {
                    binding.option4.setBackgroundColor(Color.GREEN)
                }
                else
                {
                    binding.option4.setBackgroundColor(Color.RED)
                }
            }
        }
        pressed=true
    }

    private fun nextQuestion()
    {
        binding.option1.setBackgroundColor(Color.WHITE)
        binding.option2.setBackgroundColor(Color.WHITE)
        binding.option3.setBackgroundColor(Color.WHITE)
        binding.option4.setBackgroundColor(Color.WHITE)
        currentPosition++

        if(currentPosition==16)
        {
            val intent = Intent(this, ClassificationActivity::class.java)
            intent.apply{
                putExtra("username", username)
                putExtra("answers", correctAnswers)
            }
            startActivity(intent)
            finish()
        }

        answer=setupQuestions()
        pressed = false
    }

}