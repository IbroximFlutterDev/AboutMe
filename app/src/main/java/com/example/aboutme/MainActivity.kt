package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


//        findViewById<Button>(R.id.button).setOnClickListener {
//            addNickname(it)
//        }
        binding.button.setOnClickListener { addNickname(it) }
    }

    private fun addNickname(view: View) {

        binding.apply {
            binding.nickname.text = binding.nickNameEdit.text
            invalidateAll()
            binding.nickNameEdit.visibility = View.GONE
            binding.button.visibility = View.GONE
            binding.nickname.visibility = View.VISIBLE
        }



        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}