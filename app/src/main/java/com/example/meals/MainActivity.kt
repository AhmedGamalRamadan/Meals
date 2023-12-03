package com.example.meals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meals.adapter.MealsAdapter
import com.example.meals.databinding.ActivityMainBinding
import com.example.meals.ui.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMeals.layoutManager = LinearLayoutManager(this)
        viewModel.getAllMeals()

        lifecycleScope.launch {
            try {
                binding.progressBar.isVisible = true
                viewModel.meals.collect {
                    val adapter =
                        it?.categories?.let { it1 -> MealsAdapter(this@MainActivity, it1) }
                    binding.rvMeals.adapter = adapter
                    delay(10000L)
                    binding.progressBar.isVisible = false
                }
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Error occurred", Toast.LENGTH_SHORT).show()
            } finally {
                binding.progressBar.isVisible = false
            }
        }

    }
}

