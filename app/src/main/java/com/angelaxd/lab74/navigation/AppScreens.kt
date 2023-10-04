package com.angelaxd.lab74.navigation

sealed class AppScreens(val route: String){
    object CategoriesScreen: AppScreens("primera")
    object CategoryDetail: AppScreens("segunda/{category}"){
        fun createRoute(category: String) = "segunda/$category"
    }

    object MealDetailScreen: AppScreens("tercera")
    object MealsListScreen: AppScreens("cuarta")
}
