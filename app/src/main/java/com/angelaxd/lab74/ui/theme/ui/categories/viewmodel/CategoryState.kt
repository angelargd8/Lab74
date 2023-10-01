package com.angelaxd.lab74.ui.theme.ui.categories.viewmodel

import com.angelaxd.lab74.ui.theme.networking.dto.CategoriesDto

data class CategoryState(
    /*val isLoading: Boolean = false,
    val meal: Category? = null,
    val error: String = ""*/

    val isLoading: Boolean = false,
    val categories: List<CategoriesDto> = emptyList(),
    val error: String = ""

)
