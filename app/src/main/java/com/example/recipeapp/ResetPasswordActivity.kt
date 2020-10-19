package com.example.recipeapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPasswordActivity : Activity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var emailET: EditText

    private lateinit var resetBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        auth = FirebaseAuth.getInstance()

        emailET = resetPasswordEmailAddress
        resetBtn = btnResetPasswordSubmit

        resetBtn.setOnClickListener {
            var email: String = emailET.text.toString()
            if(TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Please enter your email address", Toast.LENGTH_LONG).show()
            } else {
                auth.sendPasswordResetEmail(email).addOnCompleteListener(this, OnCompleteListener { task ->
                    if(task.isSuccessful) {
                        Toast.makeText(this, "Please check your email to reset your password", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Something went wrong, try again.", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}