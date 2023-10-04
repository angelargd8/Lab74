package com.angelaxd.lab74.networking.dto

import com.angelaxd.lab74.ui.categories.viewmodel.Category

data class CategoryDto(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)

/*
fun CategoryDto.ToCategory(): Category {
    return Category(
        idCategory =idCategory,
        strCategory = strCategory,
        strCategoryDescription = strCategoryDescription
    )
}*/