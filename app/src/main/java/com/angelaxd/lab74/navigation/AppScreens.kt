package com.angelaxd.lab74.navigation

sealed class AppScreens(val route: String){
    object CategoriesScreen: AppScreens("primera")

    //object CategoryDetail: AppScreens("segunda/{category}"){
      //  fun createRoute(category: String) = "segunda/$category"
    //}

    object MealDetailScreen: AppScreens("tercera/{category}/{id}"){
        fun createRoute(category: String, id: String) = "tercera/$category/$id"
    }
    object MealsListScreen: AppScreens("cuarta")
}
