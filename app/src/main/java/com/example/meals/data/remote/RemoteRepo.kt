package com.example.meals.data.remote

import com.example.meals.models.Categories

interface RemoteRepo {

    suspend fun getAllMeals(): Categories
}