package com.angelaxd.lab74.ui.meals.viewmodel

import com.angelaxd.lab74.networking.dto.MealX

data class MealsState(
    val isLoading: Boolean = false,
    val meals: List<MealX> = emptyList(),
    val error: String = ""
)
