package com.example.recipeapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Transition
import android.transition.TransitionManager
import android.util.Property
import android.view.*
import androidx.core.view.isVisible
import androidx.transition.Fade
import androidx.transition.Slide
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

        menuButton.setOnClickListener() {
            toggle()
        }
    }

    private fun toggle() {
        val bottomNav : View = bottomNavigation
        val homeView : ViewGroup = mainView

        var transition: Transition = Fade
        transition.setDuration(600)
        transition.addTarget(bottomNav)

        TransitionManager.beginDelayedTransition(homeView, transition)
        bottomNav.visibility = View.VISIBLE
    }
}