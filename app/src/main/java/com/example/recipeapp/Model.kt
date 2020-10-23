package com.example.recipeapp

import org.json.JSONArray

public class Model {
    lateinit var label: String
    lateinit var dishType: JSONArray
    lateinit var source: String

    constructor(label: String) {
        this.label = label
        this.dishType = dishType
        this.source = source
    }

    constructor()
}