package com.example.recipeapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RecipeListActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)
    }
}