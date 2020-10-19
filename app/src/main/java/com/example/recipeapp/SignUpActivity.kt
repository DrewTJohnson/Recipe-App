package com.example.recipeapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : Activity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var nameET: EditText

    private lateinit var emailET: EditText
    private lateinit var passwordET: EditText
    private lateinit var confirmPasswordET: EditText

    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()

        emailET = signUpEmailAddress
        passwordET = signUpPassword
        confirmPasswordET = signUpPasswordConfirm

        btnSubmit = btnSignUpSubmit

        btnSubmit.setOnClickListener{
            var email: String = emailET.text.toString()
            var password: String = passwordET.text.toString()
            var confirmPassword: String = confirmPasswordET.text.toString()

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                Toast.makeText(this, "Please fill in all available fields", Toast.LENGTH_LONG).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords must match", Toast.LENGTH_LONG).show()
            } else {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
                    if(task.isSuccessful) {
                        Toast.makeText(this, "Successfully created your account, happy cooking!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}