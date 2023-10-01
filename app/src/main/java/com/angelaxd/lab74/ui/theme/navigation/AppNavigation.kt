package com.angelaxd.lab74.ui.theme.navigation

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.angelaxd.lab74.ui.theme.ui.categories.view.CategoriesScreen
import com.angelaxd.lab74.ui.theme.ui.categories.viewmodel.CategoryViewModel
import com.angelaxd.lab74.ui.theme.ui.categories.view.CategoryDetail

@Composable
fun AppNavigation(viewModel: CategoryViewModel) {
    val navController= rememberNavController();
    NavHost(navController = navController, startDestination = AppScreens.CategoriesScreen.route){
        composable(route= AppScreens.CategoriesScreen.route){
            //AppScreens.MealSListScreen(navController)
            CategoriesScreen(navController, viewModel = viewModel)
        }

        composable(route= AppScreens.CategoryDetail.route + "/{id}",
            arguments = listOf(navArgument(name= "id"){
                type= NavType.StringType
            }
            )
            ){
            CategoryDetail(navController, it.arguments?.getString("/id"))

        }

        /*composable(route= AppScreens.CategoryDetail.route + "/{id}"+ "/{str}"+ "/{description}"+ "/{thumb}"){
                backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            val str = backStackEntry.arguments?.getString("str")
            val description = backStackEntry.arguments?.getString("description")
            val thumb = backStackEntry.arguments?.getString("thumb")
            Log.d(ContentValues.TAG, "---BANDERA de paso---");
            CategoryDetail(id,str,description,thumb)
        }*/
        //composable(route= AppScreens.CategoriesScreen.route){
        //  CategoriesScreen(navController)
        //}


    }

}
