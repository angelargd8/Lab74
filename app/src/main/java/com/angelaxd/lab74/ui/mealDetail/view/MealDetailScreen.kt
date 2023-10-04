package com.angelaxd.lab74.ui.mealDetail.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.angelaxd.lab74.ui.mealDetail.viewmodel.MealDetailViewModel
import com.angelaxd.lab74.ui.objetos.Texto

@Composable
fun MealDetailScreen(
    navController: NavHostController,
    name: String?,
    id: String? // ?=opcional
){

    val viewModel: MealDetailViewModel= viewModel()

    val filters = viewModel.MealDetailState.value

    Column {
        Spacer(modifier = Modifier.height(10.dp))
        Texto("Meals Details")
        id?.let {
            Texto(name.toString())

            if(name == "Seafood"){
                LazyColumn(){
                    filters?.let {
                        items(filters){
                                filter->
                            val nombre: String= filter.strMeal
                            val idFilter: String = filter.idMeal
                            val thumb: String = filter.strMealThumb
                            //Texto(texto = nombre)

                            Card(modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth()
                                .clickable { },
                                shape = RoundedCornerShape(6.dp)

                            ) {
                                Row {
                                    AsyncImage(
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data(thumb)
                                            .transformations()
                                            .size(299,299)
                                            .build()
                                        ,
                                        contentDescription = "imagen jaja"
                                    )
                                    Column {
                                        Text(text =nombre,
                                            fontSize = 15.sp,
                                            color = Color(0xFF6200EE),
                                            fontWeight= FontWeight.Bold, //grosor del texto
                                            fontStyle = FontStyle.Italic, //estilo (normal, cursiva..)
                                            lineHeight = 20.sp, //altura de linea del texto
                                            overflow = TextOverflow.Ellipsis //como se maneja el desbordamiento
                                        )
                                        Spacer(modifier =Modifier.height(2.dp))

                                    }
                                }

                            }



                        }
                    }
                }

            }else{
                Text(text ="  no hay información acerca de esta categoria",
                    fontSize = 10.sp,
                    color = Color(0xFFE91E63),
                    overflow = TextOverflow.Ellipsis //como se maneja el desbordamiento
                )

            }



        }//id?.let



    }

}