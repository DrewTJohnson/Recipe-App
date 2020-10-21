package com.example.recipeapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.Toast
import kotlinx.android.synthetic.main.bottom_navigation.*
import kotlinx.android.synthetic.main.menu_button.*
import okhttp3.*
import java.io.IOException

class RecipeListActivity : Activity() {

    private val isUp: Boolean = false
    private val isClickable: Boolean = false

    private val client = OkHttpClient()

    private val token = "f6f7f9802723fecea4632db9f05fbf89"

    companion object {
        var QUERY = "query"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        setQuery()

        run("https://api.edamam.com/search?q=&mealType=${QUERY}&app_id=0388079f&app_key=${token}")

        bottomNavigation.visibility = View.INVISIBLE
        isUp

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

    fun setQuery() {
            if(intent != null) {
                QUERY = intent.getStringExtra(QUERY).toString()
        } else {
            Log.e("Cancelled", "Cancelled")
            Toast.makeText(this, "Didn't work", Toast.LENGTH_SHORT).show()
        }
    }



    fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) { }

            override fun onResponse(call: Call, response: Response) = println(response.body()?.string())
        })
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