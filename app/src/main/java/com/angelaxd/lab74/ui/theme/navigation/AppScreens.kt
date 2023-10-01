package com.angelaxd.lab74.ui.theme.navigation

sealed class AppScreens(val route: String){
    object CategoriesScreen: AppScreens("primera")
    object CategoryDetail: AppScreens("segunda")
    object MealDetailScreen: AppScreens("cuarta")
    object MealsListScreen: AppScreens("tercera")
}
