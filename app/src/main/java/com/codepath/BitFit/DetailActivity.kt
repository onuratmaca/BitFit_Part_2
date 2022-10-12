package com.codepath.BitFit

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.codepath.articlesearch.R
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class DetailActivity : AppCompatActivity() {
    private lateinit var foodTextView: TextView
    private lateinit var caloriesTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        // TODO: Find the views for the screen
        foodTextView = findViewById(R.id.food_ET)
        caloriesTextView = findViewById(R.id.calories_ET)

        // TODO: Get the extra from the Intent
        //val food = intent.getParcelableExtra<Food1>(FOOD_EXTRA) as Food1

        // TODO: Set the title, byline, and abstract information from the article

        //foodTextView.text = food.name
        //caloriesTextView.text = food.calories.toString()

        findViewById<Button>(R.id.submit_BT).setOnClickListener {
            lifecycleScope.launch(IO) {
                //(application as FoodApplication).db.foodDAO().deleteAll()
                (application as FoodApplication).db.foodDAO().insert(
                    FoodEntity(
                        name = foodTextView.text.toString(),
                        calories = caloriesTextView.text.toString().toDouble()
                    )
                )
            }
        }

    }
}