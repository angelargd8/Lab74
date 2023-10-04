package com.angelaxd.lab74.ui.categories.viewmodel

import com.angelaxd.lab74.networking.dto.CategoriesDto

data class CategoryState(
    val isLoading: Boolean = false,
    val categories: List<CategoriesDto> = emptyList(),
    val error: String = ""
)
