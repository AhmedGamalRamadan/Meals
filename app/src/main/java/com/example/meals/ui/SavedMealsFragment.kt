package com.example.meals.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meals.databinding.FragmentSavedMealsBinding


class SavedMealsFragment : Fragment() {
    private lateinit var binding :FragmentSavedMealsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSavedMealsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}