package com.example.meals.data.remote


class RemoteRepoImp(private val apiService:APIService)  :RemoteRepo {

    override suspend fun getAllMeals()=apiService.getAllMeals()

}