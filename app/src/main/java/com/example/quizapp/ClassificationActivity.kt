package com.example.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityClassificationBinding

class ClassificationActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityClassificationBinding

    private var username: String? = null
    private var correctAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityClassificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Receives the username inserted
        username = intent.getStringExtra("username")

        // Receives the number of question answered correctly
        correctAnswers = intent.getIntExtra("answers",0)

        binding.score.text=correctAnswers.toString()
        binding.username.text=username
    }

}