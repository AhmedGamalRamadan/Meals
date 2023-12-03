package com.example.meals.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meals.data.remote.RemoteRepoImp
import com.example.meals.data.remote.RetrofitBuilder
import com.example.meals.models.Categories
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel  :ViewModel() {
    private val remoteRepoImp:RemoteRepoImp

    init {
        val service=RetrofitBuilder.apiMeals
        remoteRepoImp = RemoteRepoImp(service)
    }

    private val _meals =MutableStateFlow<Categories?>(null)
     val meals:StateFlow<Categories?> = _meals

    fun getAllMeals(){
        viewModelScope.launch {
           val response: Categories = remoteRepoImp.getAllMeals()
            try {
                _meals.value =response

            }catch (e:Exception){
                Log.d("MainViewModel",e.message.toString())
            }
        }
    }
}