package com.angelaxd.lab74.ui.mealDetail.repository

import com.angelaxd.lab74.networking.MealWebService
import com.angelaxd.lab74.networking.dto.FilterDto


class MealDetailRepositoryImpl(private val webService: MealWebService = MealWebService()) {
    suspend fun getMealsDetails(): FilterDto{
        return webService.getMealsFilter()
    }
}