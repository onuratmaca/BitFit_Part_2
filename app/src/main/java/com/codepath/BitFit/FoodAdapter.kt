package com.codepath.BitFit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codepath.articlesearch.R

const val FOOD_EXTRA = "FOOD_EXTRA"

class FoodAdapter(private val context: Context, private val foods: List<DisplayFood>) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fit_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO: Get the individual article and bind to holder

        val food = foods[position]
        holder.bind(food)


    }

    override fun getItemCount() = foods.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val foodTextView = itemView.findViewById<TextView>(R.id.name_TV)
        private val caloriesTextView = itemView.findViewById<TextView>(R.id.calories_TV)


        init {
            itemView.setOnClickListener(this)
        }

        // TODO: Write a helper method to help set up the onBindViewHolder method
        fun bind(food: DisplayFood) {
            //item_tv_show
            foodTextView.text = food.foodName
            caloriesTextView.text = food.calories.toString()
        }



        override fun onClick(v: View?) {
            // TODO: Get selected article
            /*
            val food = foods[absoluteAdapterPosition]

            val f = Food1(food.name,food.calories)

            // TODO: Navigate to Details screen and pass selected article
            val intent = Intent(context, DetailActivity::class.java)
                .putExtra(FOOD_EXTRA, f)

            context.startActivity(intent)

             */
        }
    }
}