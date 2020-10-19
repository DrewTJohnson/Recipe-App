package com.example.recipeapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var emailET: EditText
    private lateinit var passwordET: EditText

    private lateinit var loginBtn: Button

    private lateinit var resetPasswordTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailET = loginEmailAddress
        passwordET = loginPassword

        loginBtn = btnLogin

        resetPasswordTV = havingTrouble

        auth = FirebaseAuth.getInstance()

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        loginBtn.setOnClickListener() {
            var email: String = emailET.text.toString()
            var password: String = passwordET.text.toString()

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(this, "Enter your username and password", Toast.LENGTH_LONG).show()
                } else {
                    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
                        if(task.isSuccessful) {
                            Toast.makeText(this, "Happy cooking!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, HomeScreenActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Check your email and password", Toast.LENGTH_LONG).show()
                        }
                    })
            }
        }

        btnSignUp.setOnClickListener() {
            val signUp = Intent(this, SignUpActivity::class.java)
            startActivity(signUp)
        }
    }
}