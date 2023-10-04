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

@Composable
fun AppNavigation() {
    val navController= rememberNavController();

    NavHost(navController = navController, startDestination = AppScreens.CategoriesScreen.route){
        composable(route= AppScreens.CategoriesScreen.route){
            //AppScreens.MealSListScreen(navController)
            CategoriesScreen(navController)
        }

        composable(route= AppScreens.CategoryDetail.route,
            arguments = listOf(navArgument(name= "category"){
                type= NavType.StringType
            }
            )){backStackEntry->
            val arguments = requireNotNull(backStackEntry.arguments)
            val categoryName= arguments.getString("category") ?:""
            CategoryDetail(navController = navController, id = categoryName)


        }

    }

}
