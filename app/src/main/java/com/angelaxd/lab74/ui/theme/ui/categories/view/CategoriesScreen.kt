package com.angelaxd.lab74.ui.theme.ui.categories.view

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.angelaxd.lab74.ui.theme.navigation.AppScreens
import com.angelaxd.lab74.ui.theme.ui.categories.viewmodel.CategoryViewModel
import com.angelaxd.lab74.ui.theme.ui.objetos.Texto


@Composable
fun CategoriesScreen(
    navController: NavHostController,
    viewModel: CategoryViewModel
) {
    val categories by viewModel.listCategories.observeAsState(initial= null)

    LaunchedEffect(Unit){
        viewModel.FetchCategories()
    }
    Column {
        Texto("Categorias")
        Spacer(modifier =Modifier.height(10.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()){

            categories?.let{
                Log.d(TAG, "---BANDERA 2---");
                items(it.categories){ category->

                    val str: String = category.strCategory
                    val id: String = category.idCategory
                    val description: String = category.strCategoryDescription
                    val thumb: String = category.strCategoryThumb

                    //Log.d(TAG, "---BANDERA pp---")

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)
                        ,
                        //manadr el id, luego con otro de estos mostrar
                        onClick = {

                            //navController.navigate("categoryDetail/${id}/${str}/${description}/${thumb}")
                            navController.navigate(AppScreens.CategoryDetail.route +"/esto es un parametro")

                            //navController.navigate(AppScreens.MealDetailScreen.route)
                            //navController.navigate(AppScreens.CategoryDetail.route +"/${id}"+"/${str}"+"/${description}"+"/${thumb}" )

                                  },
                        contentPadding = PaddingValues(2.dp)
                    ) {
                        Text(
                            text = category.strCategory,
                            fontSize = 20.sp,
                            modifier= Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            //color= Color.Black
                        )

                    }
                }
            }

        }//lazycolumn


    }







}