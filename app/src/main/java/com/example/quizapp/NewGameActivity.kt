package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityNewGameBinding

class NewGameActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityNewGameBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityNewGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playerName.setOnKeyListener {
                view, keyCode, _ -> handleKeyEvent(view, keyCode)
        }

        binding.buttonStartGame.setOnClickListener {
            if (binding.playerName.editText?.text.toString().isEmpty())
            {
                Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT).show()
            }
            else
            {
                val intent = Intent(this, GameActivity::class.java)
                intent.putExtra("username", binding.playerName.editText?.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean
    {
        if (keyCode == KeyEvent.KEYCODE_ENTER)
        {
            // Hide the keyboard
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }

}