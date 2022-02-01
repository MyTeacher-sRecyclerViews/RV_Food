package com.example.friendlyeats.adapter

import android.app.ProgressDialog
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.friendlyeats.R
import com.example.friendlyeats.listener.OnBottomClickListener
import com.example.friendlyeats.model.Food

class FoodAdapter(
    val context: Context,
    private val foodList: ArrayList<Food>,
    private val listener: OnBottomClickListener
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.food_item_layout, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]

        if (holder is FoodViewHolder) {

            if (position == foodList.size -1) {
                listener.onBottomListener(position)
            }

            holder.apply {
                imageView.setImageResource(food.imageView)
                resName.text = food.resName
                rating.rating = food.rating
                subTitle.text = food.subTitle
            }
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.food_image)
        val resName: TextView = view.findViewById(R.id.food_name)
        val rating: RatingBar = view.findViewById(R.id.rating_bar)
        val subTitle: TextView = view.findViewById(R.id.food_subtitle)

    }
}