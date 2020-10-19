package com.example.recipeapp

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Property
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.menu_button.*

class HomeScreenActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        cvBreakfastCard.setOnClickListener() {
            val recipeList = Intent(this, RecipeListActivity::class.java)
            startActivity(recipeList)
        }

//        menuButton.setOnClickListener() {
//            buttonGrow()
//        }
    }

    private fun buttonGrow() {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 10f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 10f)

        val animator = ObjectAnimator.ofPropertyValuesHolder(menuButton, scaleX, scaleY)

        animator.start()
    }
}