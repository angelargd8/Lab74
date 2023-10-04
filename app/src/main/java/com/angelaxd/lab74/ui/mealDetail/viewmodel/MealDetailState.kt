package com.angelaxd.lab74.ui.mealDetail.viewmodel

import com.angelaxd.lab74.networking.dto.Meal

data class MealDetailState(
    val isLoading: Boolean = false,
    val filter: List<Meal> = emptyList(),
    val error: String = ""

)
