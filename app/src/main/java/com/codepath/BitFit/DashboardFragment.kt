package com.codepath.BitFit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.codepath.articlesearch.R
import kotlinx.coroutines.launch


class DashboardFragment : Fragment() {
    private lateinit var foodsRecyclerView: RecyclerView
    private val foods = mutableListOf<DisplayFood>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val averageCalories = view.findViewById<TextView>(R.id.average_caloriesTV)
        val minCalories = view.findViewById<TextView>(R.id.minimum_calorieTV)
        val maxCalories = view.findViewById<TextView>(R.id.maximum_calorieTV)

        val foodAdapter = FoodAdapter(view.context, foods)

        var minCal = 0
        var maxCal = 0
        var avgCal = 0



        lifecycleScope.launch {
            (activity?.application as FoodApplication).db.foodDAO().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    DisplayFood(
                        entity.name, entity.calories
                    )
                }.also { mappedList ->
                    foods.clear()
                    foods.addAll(mappedList)
                    maxCalories.text = foods.size.toString()
                    foodAdapter.notifyDataSetChanged()
                }
            }
        }


        return view
    }

    companion object {
        fun newInstance(): DashboardFragment {
            return DashboardFragment()
        }
    }
}