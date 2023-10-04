package com.angelaxd.lab74.ui.mealDetail.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angelaxd.lab74.networking.dto.Meal
import com.angelaxd.lab74.ui.categories.repository.CategoryRepositoryImpl
import com.angelaxd.lab74.ui.mealDetail.repository.MealDetailRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealDetailViewModel (
    private val repository: MealDetailRepositoryImpl = MealDetailRepositoryImpl()

):ViewModel(){
    val MealDetailState: MutableState<List<Meal>> = mutableStateOf(emptyList<Meal>())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val mealsDetails = getFilters()
            MealDetailState.value = mealsDetails
        }
    }

    private suspend fun getFilters(): List<Meal>{
        return repository.getMealsDetails().meals
    }



}