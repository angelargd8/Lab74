package com.angelaxd.lab74.ui.categories.view

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.angelaxd.lab74.navigation.AppScreens
import com.angelaxd.lab74.ui.categories.viewmodel.CategoryViewModel
import com.angelaxd.lab74.ui.objetos.Texto


@Composable
fun CategoriesScreen(navController: NavHostController) {

    val viewModel: CategoryViewModel= viewModel()
    //categories, variable que notifica cada vez que hay un cambio en el estado de categoriesState
    //para redibujar la pantalla
    val categories= viewModel.categoriesState.value

    Column {
        Texto("Categorias")
        Spacer(modifier =Modifier.height(10.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()){

            categories?.let{
                Log.d(TAG, "---BANDERA 2---");
                items(categories){ category->

                    val str: String = category.strCategory
                    val id: String = category.idCategory
                    val description: String = category.strCategoryDescription
                    val thumb: String = category.strCategoryThumb

                    Card(modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(AppScreens.CategoryDetail.createRoute(str)) {
                                launchSingleTop = true
                            }
                        },
                        shape= RoundedCornerShape(6.dp)
                    ){
                        Row {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(thumb)
                                    .transformations()
                                    .size(499,499)
                                    .build()
                                ,
                                contentDescription = "imagen jaja"
                            )
                            Column(modifier = Modifier.padding(6.dp)) {
                                //Spacer(modifier =Modifier.height(2.dp))
                                Text(text =str,
                                    fontSize = 15.sp,
                                    fontWeight= FontWeight.Bold, //grosor del texto
                                    fontStyle = FontStyle.Italic, //estilo (normal, cursiva..)
                                    lineHeight = 20.sp, //altura de linea del texto
                                    overflow = TextOverflow.Ellipsis //como se maneja el desbordamiento
                                )
                                Spacer(modifier =Modifier.height(2.dp))
                                Text(text = description,
                                    fontSize = 8.sp,
                                    fontWeight= FontWeight.Bold, //grosor del texto
                                    fontStyle = FontStyle.Normal, //estilo (normal, cursiva..)
                                    lineHeight = 13.sp, //altura de linea del texto
                                    overflow = TextOverflow.Ellipsis //como se maneja el desbordamiento

                                )

                            }

                        }


                    }




                }
            }

        }//lazycolumn


    }







}