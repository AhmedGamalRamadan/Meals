package com.example.meals.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meals.adapter.MealsAdapter
import com.example.meals.databinding.FragmentHomeBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel :MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvMeals.layoutManager = LinearLayoutManager(requireActivity())
        viewModel.getAllMeals()

        lifecycleScope.launch {
            try {
                binding.progressBar.isVisible = true
                viewModel.meals.collect {
                    val adapter =
                        it?.categories?.let { it1 -> MealsAdapter(requireContext(), it1) }
                    binding.rvMeals.adapter = adapter
                    delay(10000L)
                    binding.progressBar.isVisible = false
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error occurred", Toast.LENGTH_SHORT).show()
            } finally {
                binding.progressBar.isVisible = false
            }
        }
    }

}