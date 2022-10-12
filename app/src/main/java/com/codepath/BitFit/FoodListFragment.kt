package com.codepath.BitFit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.articlesearch.R
import com.codepath.articlesearch.databinding.ActivityMainBinding
import kotlinx.coroutines.launch


class FoodListFragment : Fragment() {
    private lateinit var foodsRecyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private val foods = mutableListOf<DisplayFood>()
    private lateinit var application: FoodApplication


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_food_list, container, false)

        foodsRecyclerView = view.findViewById(R.id.fragment_recycler_view)

        // TODO: Set up FoodAdapter with food list
        val foodAdapter = FoodAdapter(view.context, foods)
        foodsRecyclerView.adapter = foodAdapter


        lifecycleScope.launch {
            application.db.foodDAO().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    DisplayFood(
                        entity.name, entity.calories
                    )
                }.also { mappedList ->
                    foods.clear()
                    foods.addAll(mappedList)
                    foodAdapter.notifyDataSetChanged()
                }
            }
        }

        foodsRecyclerView.layoutManager = LinearLayoutManager(view.context).also {
            val dividerItemDecoration = DividerItemDecoration(view.context, it.orientation)
            foodsRecyclerView.addItemDecoration(dividerItemDecoration)
        }

        return view
    }

    companion object {
        fun newInstance(): FoodListFragment {
            return FoodListFragment()
        }
    }
}
