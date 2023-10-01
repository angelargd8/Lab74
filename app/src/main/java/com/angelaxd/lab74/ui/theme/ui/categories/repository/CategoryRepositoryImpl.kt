package com.angelaxd.lab74.ui.theme.ui.categories.repository

import com.angelaxd.lab74.ui.theme.networking.MealsApi
import com.angelaxd.lab74.ui.theme.networking.dto.CategoriesDto
import com.angelaxd.lab74.ui.theme.ui.categories.viewmodel.Category

class CategoryRepositoryImpl(private val api: MealsApi) {

    suspend fun getCategories(): CategoriesDto{
        return api.getCategories()
    }


}