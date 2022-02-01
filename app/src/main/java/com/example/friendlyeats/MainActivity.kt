package com.example.friendlyeats

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.friendlyeats.adapter.FoodAdapter
import com.example.friendlyeats.listener.OnBottomClickListener
import com.example.friendlyeats.model.Food

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var foodList: ArrayList<Food> = ArrayList()
    private lateinit var foodAdapter: FoodAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        foodAdapter = FoodAdapter(this, foodList(), object : OnBottomClickListener {
            override fun onBottomListener(position: Int) {
                Handler(Looper.getMainLooper()).postDelayed({
                    val progressDialog = ProgressDialog(this@MainActivity)
                    progressDialog.setTitle("One moment..")
                    progressDialog.show()
                },1000)
            }
        })
        recyclerView.adapter = foodAdapter

    }

    private fun foodList(): ArrayList<Food> {
        foodList.add(Food(R.drawable.food_1, "Diner StreakHouse", 3f, "Restaurant"))
        foodList.add(Food(R.drawable.food, "Fire Hyper", 5f, "Restaurant"))
        foodList.add(Food(R.drawable.fast_2, "Diner StreakHouse", 2f, "Restaurant"))
        foodList.add(Food(R.drawable.fast_4, "Diner StreakHouse", 5f, "Restaurant"))
        foodList.add(Food(R.drawable.nov, "Diner StreakHouse", 4f, "Restaurant"))
        foodList.add(Food(R.drawable.osh, "Deli Cious ", 4f, "Restaurant"))
        foodList.add(Food(R.drawable.fast_3, "Diner StreakHouse", 5f, "Restaurant"))
        foodList.add(Food(R.drawable.fast_5, "Diner StreakHouse", 3f, "Restaurant"))
        foodList.add(Food(R.drawable.fast_6, "Diner StreakHouse", 4f, "Restaurant"))
        foodList.add(Food(R.drawable.nov, "Diner StreakHouse", 4f, "Restaurant"))
        foodList.add(Food(R.drawable.osh, "Deli Cious ", 4f, "Restaurant"))
        foodList.add(Food(R.drawable.fast_7, "Diner StreakHouse", 5f, "Restaurant"))
        foodList.add(Food(R.drawable.fast_8, "Diner StreakHouse", 2f, "Restaurant"))
        foodList.add(Food(R.drawable.nov, "Diner StreakHouse", 4f, "Restaurant"))
        foodList.add(Food(R.drawable.osh, "Deli Cious ", 4f, "Restaurant"))

        return foodList
    }
}