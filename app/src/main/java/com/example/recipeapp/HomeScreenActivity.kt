package com.example.recipeapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Transition
import android.transition.TransitionManager
import android.util.Property
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import android.widget.Toast
import androidx.core.view.ViewCompat.animate
import androidx.core.view.isVisible
import androidx.transition.Fade
import androidx.transition.Slide
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.menu_button.*

class HomeScreenActivity : Activity() {

//    private val bottomNav = bottomNavigation
    private val isUp: Boolean = false
    private val isClickable: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        bottomNavigation.visibility = View.INVISIBLE
        isUp

        cvBreakfastCard.setOnClickListener() {
            val recipeList = Intent(this, RecipeListActivity::class.java)
            startActivity(recipeList)
        }

        menuButton.setOnClickListener() {
            buttonSlideDown()
            slideUp()
            menuCloseButton.isClickable = !isClickable
        }
        menuCloseButton.setOnClickListener() {
            buttonSlideUp()
            slideDown()
            menuCloseButton.isClickable = isClickable
        }
    }

    private fun slideUp() {
        bottomNavigation.visibility = View.VISIBLE

        val animateMenu = TranslateAnimation(
                0F,
                0F,
                bottomNavigation.height.toFloat(),
                0F)
        animateMenu.duration = 200
        animateMenu.fillAfter = true
        bottomNavigation.startAnimation(animateMenu)
    }

    private fun buttonSlideDown() {
        val animateButton = TranslateAnimation(
                0F,
                0F,
                0F,
                bottomNavigation.height.toFloat())
        animateButton.duration = 400
        animateButton.fillAfter = true
        menuButton.startAnimation(animateButton)
    }

    private fun slideDown() {
        val animate = TranslateAnimation(
                0F,
                0F,
                0F,
                bottomNavigation.height.toFloat())
        animate.duration = 400
        animate.fillAfter = true
        bottomNavigation.startAnimation(animate)
    }

    private fun buttonSlideUp() {
        val animateButton = TranslateAnimation(
                0F,
                0F,
                bottomNavigation.height.toFloat(),
                0F)
        animateButton.duration = 200
        animateButton.fillAfter = true
        menuButton.startAnimation(animateButton)
    }
}