package com.angelaxd.lab74.navigation


import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.angelaxd.lab74.ui.categories.view.CategoriesScreen
import com.angelaxd.lab74.ui.categories.view.CategoryDetail
import com.angelaxd.lab74.ui.mealDetail.view.MealDetailScreen
import com.angelaxd.lab74.ui.meals.view.mealsScreen

@Composable
fun AppNavigation() {
    val navController= rememberNavController();

    NavHost(navController = navController, startDestination = AppScreens.CategoriesScreen.route){
        composable(route= AppScreens.CategoriesScreen.route){
            CategoriesScreen(navController)
        }

        composable(route= AppScreens.MealDetailScreen.route,
            arguments = listOf(navArgument(name= "category"){
                type= NavType.StringType
            }
            )){backStackEntry->
            val arguments = requireNotNull(backStackEntry.arguments)
            val categoryName= arguments.getString("category") ?:""
            val idCategory= arguments.getString("id") ?:""

            MealDetailScreen(navController = navController, name = categoryName, id = idCategory )

        }

        composable(route= AppScreens.MealsScreen.route,
            arguments = listOf(navArgument(name= "idFilter"){
                type= NavType.StringType
            }
            )){backStackEntry->
            val arguments = requireNotNull(backStackEntry.arguments)
            val idFilter= arguments.getString("idFilter") ?:""

            mealsScreen(navController = navController, id = idFilter )

        }

    }

}
