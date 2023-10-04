package com.angelaxd.lab74.ui.meals.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angelaxd.lab74.networking.dto.MealX
import com.angelaxd.lab74.networking.dto.MealsDto
import com.angelaxd.lab74.ui.meals.repository.MealsRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class MealsViewModel(
    private val repository: MealsRepositoryImpl= MealsRepositoryImpl()
):ViewModel() {

    val mealsState: MutableState<List<MealX>> = mutableStateOf(emptyList<MealX>())

    init {
        viewModelScope.launch(Dispatchers.IO) {
        val meals = getMeals()
            mealsState.value= meals

        }
    }

    private suspend fun getMeals(): List<MealX>{
        return repository.getMeals().meals
    }

}