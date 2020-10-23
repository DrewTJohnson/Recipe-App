package com.example.recipeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.adapter_layout.view.*

class CustomAdapter(context: Context, ArrayListDetails: ArrayList<Model>) : BaseAdapter() {
    private val layoutInflater: LayoutInflater
    private val arrayListDetails: ArrayList<Model>

    init {
        this.layoutInflater = LayoutInflater.from(context)
        this.arrayListDetails = ArrayListDetails
    }

    override fun getCount(): Int {
        return arrayListDetails.size
    }

    override fun getItem(position: Int): Any {
        return arrayListDetails.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View?
        val listRowHolder: ListRowHolder

        if(convertView == null) {
            view = this.layoutInflater.inflate(R.layout.adapter_layout, parent, false)
            listRowHolder = ListRowHolder(view)
            view.tag = listRowHolder
        } else {
            view = convertView
            listRowHolder = view.tag as ListRowHolder
        }

        listRowHolder.recipeListRecipeName.text = arrayListDetails.get(position).label
        listRowHolder.recipeListSource.text = arrayListDetails.get(position).source
//        listRowHolder.recipeListRecipeImage. = arrayListDetails.get(position).image
        return view
    }
}

private class ListRowHolder(row: View?) {
    val recipeListRecipeName: TextView = row?.recipeListRecipeName as TextView
    val recipeListSource: TextView = row?.recipeListSource as TextView
//    public val recipeListRecipeImage: ImageView = row?.recipeListRecipeImage as ImageView
}