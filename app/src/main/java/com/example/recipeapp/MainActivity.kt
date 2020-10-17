package com.example.recipeapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnLogin.setOnClickListener() {
            val login = Intent(this, HomeScreenActivity::class.java)
            startActivity(login)
        }

        btnSignUp.setOnClickListener() {
            val signUp = Intent(this, SignUpActivity::class.java)
            startActivity(signUp)
        }
    }
}