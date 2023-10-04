package com.angelaxd.lab74.ui.categories.repository

import com.angelaxd.lab74.networking.MealWebService
import com.angelaxd.lab74.networking.MealsApi
import com.angelaxd.lab74.networking.dto.CategoriesDto
import com.angelaxd.lab74.ui.categories.viewmodel.Category

//(private val webService: WebService) --> de una vez se instancia alli
//usando el modelo singletown
class CategoryRepositoryImpl(private val webService: MealWebService= MealWebService()) {

    suspend fun getCategories(): CategoriesDto {
        return webService.getMealsCategories()
    }


}