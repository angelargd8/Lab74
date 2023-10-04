package com.angelaxd.lab74.ui.meals.repository

import com.angelaxd.lab74.networking.MealWebService
import com.angelaxd.lab74.networking.dto.MealsDto


class MealsRepositoryImpl(private val webService: MealWebService = MealWebService()) {
    suspend fun getMeals(): MealsDto{
        return webService.getLookUp()
    }
}