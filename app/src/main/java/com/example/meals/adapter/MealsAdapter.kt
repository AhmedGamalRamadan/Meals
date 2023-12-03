package com.example.meals.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.meals.databinding.MealsRowBinding
import com.example.meals.models.Category

class MealsAdapter(val context: Context, val mealsList: List<Category>) :
    RecyclerView.Adapter<MealsAdapter.MealsViewHolder>() {


    class MealsViewHolder(val binding: MealsRowBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
        return MealsViewHolder(
            MealsRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {

        return mealsList.size
    }

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {

        val mealsPosition = mealsList[position]

        holder.binding.apply {

            tvMealsDescription.text = mealsPosition.strCategoryDescription
            tvMealsName.text =mealsPosition.strCategory
            Glide.with(root.context).load(mealsPosition.strCategoryThumb).into(ivMeals)
        }

        }
    }
