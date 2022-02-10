package com.example.friendlyeats

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.friendlyeats.adapter.FoodAdapter
import com.example.friendlyeats.model.Food

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var foodList: ArrayList<Food> = ArrayList()
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressbar)
        recyclerView = findViewById(R.id.recyclerview)
        foodAdapter = FoodAdapter(this, foodList())
        recyclerView.adapter = foodAdapter
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager = GridLayoutManager::class.java.cast(recyclerView.layoutManager)
                val totalItemCount = layoutManager.itemCount
                val lastVisible = layoutManager.findLastVisibleItemPosition()
                val end = lastVisible + 5 >= totalItemCount
                if (totalItemCount > 0 && end) {
                    foodAdapter.addFoods(foodList())
                    Handler(Looper.getMainLooper()).postDelayed({
                        progressBar.visibility = View.GONE
                    },3000)
                    progressBar.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun foodList(): ArrayList<Food> {
        foodList.add(Food(R.drawable.food_1, "Diner StreakHouse", 3f, "Restaurant"))
        foodList.add(Food(R.drawable.food, "Fire Hyper", 5f, "Restaurant"))
        foodList.add(Food(R.drawable.fast_2, "Diner StreakHouse", 2f, "Restaurant"))
        foodList.add(Food(R.drawable.fast_4, "Diner StreakHouse", 5f, "Restaurant"))
        foodList.add(Food(R.drawable.nov, "Diner StreakHouse", 4f, "Restaurant"))
        foodList.add(Food(R.drawable.osh, "Deli Cious ", 4f, "Restaurant"))
        foodList.add(Food(R.drawable.fast_3, "Diner StreakHouse", 5f, "Restaurant"))
        foodList.add(Food(R.drawable.osh, "Deli Cious ", 4f, "Restaurant"))

        return foodList
    }
}