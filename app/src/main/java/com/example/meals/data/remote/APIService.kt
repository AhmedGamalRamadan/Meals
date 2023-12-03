package com.example.meals.data.remote

import com.example.meals.models.Categories
import com.example.meals.models.Category
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("categories.php")
    suspend fun getAllMeals():Categories


}

//https://www.themealdb.com/api/json/v1/1/categories.php