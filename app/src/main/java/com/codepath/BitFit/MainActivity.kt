package com.codepath.BitFit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.articlesearch.R
import com.codepath.articlesearch.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch


private const val TAG = "MainActivity/"


class MainActivity : AppCompatActivity() {
    private lateinit var foodsRecyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private val foods = mutableListOf<DisplayFood>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        replaceFragment(FoodListFragment())

        val fragmentManager: FragmentManager = supportFragmentManager

        val foodListFragment: Fragment = FoodListFragment()
        val dashboardFragment: Fragment = DashboardFragment()

        val bottomNavigationBarView: BottomNavigationView = findViewById(R.id.bottom_navigation)


        bottomNavigationBarView.setOnItemSelectedListener { item ->
            lateinit var thisFragment: Fragment
            when (item.itemId){
                R.id.log -> thisFragment = foodListFragment
                R.id.dashboard -> thisFragment = dashboardFragment
            }
            replaceFragment(thisFragment)
            true
        }



        bottomNavigationBarView.selectedItemId = R.id.log
        /*
        foodsRecyclerView = findViewById(R.id.main_rView)
        // TODO: Set up FoodAdapter with tv shows
        val foodAdapter = FoodAdapter(this, foods)
        foodsRecyclerView.adapter = foodAdapter

        lifecycleScope.launch {
            (application as FoodApplication).db.foodDAO().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    DisplayFood(
                        entity.name,
                        entity.calories
                    )
                }.also { mappedList ->
                    foods.clear()
                    foods.addAll(mappedList)
                    foodAdapter.notifyDataSetChanged()
                }
            }
        }


        foodsRecyclerView.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            foodsRecyclerView.addItemDecoration(dividerItemDecoration)
        }



        findViewById<Button>(R.id.addNew_BT).setOnClickListener{
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

         */


        /*
        findViewById<Button>(R.id.reset_BT).setOnClickListener{
            (application as FoodApplication).db.foodDAO().deleteAll()
        }

         */
    }

    private fun replaceFragment(thisFragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout_try, thisFragment)
        fragmentTransaction.commit()
    }
}