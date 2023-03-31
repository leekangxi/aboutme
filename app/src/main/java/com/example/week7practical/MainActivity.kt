package com.example.week7practical

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.week7practical.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }

        //setContentView(R.layout.activity_main)
        //findViewById<Button>(R.id.done_button).setOnClickListener {
       //     addNickname(it)
       // }

      //  findViewById<TextView>(R.id.nickname_text).setOnClickListener {
       //     updateNickname(it)
      //  }
    }


    private fun addNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = VISIBLE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)


    }

    private fun updateNickname(view:View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)

        editText.visibility = View.VISIBLE

        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus()
    }



}

