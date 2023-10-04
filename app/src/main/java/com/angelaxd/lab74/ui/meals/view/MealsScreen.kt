package com.angelaxd.lab74.ui.meals.view

import android.widget.ListView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.angelaxd.lab74.ui.meals.viewmodel.MealsViewModel
import com.angelaxd.lab74.ui.objetos.Texto
import com.angelaxd.lab74.ui.objetos.TextoDescripcion

@Composable
fun mealsScreen(
    navController: NavHostController,
    id: String?

    ){
    val viewModel: MealsViewModel = viewModel()
    val lookup = viewModel.mealsState.value

    Column {
        Spacer(modifier = Modifier.height(10.dp))
        Texto("Meal")
        id?.let {
            //Texto(id.toString())
            if(id == "52944"){
                LazyColumn(){
                    lookup?.let {
                        items(lookup){
                            meal->
                            val idMeal: String= meal.idMeal
                            val nombre: String= meal.strMeal

                            //Card {
                                Column {
                                    Texto(texto = nombre)
                                    TextoDescripcion("Area: "+meal.strArea)
                                    TextoDescripcion("Preparacion: "+meal.strInstructions)
                                    TextoDescripcion("Ingredientes: "+meal.strIngredient1)
                                    TextoDescripcion(meal.strIngredient2)
                                    TextoDescripcion(meal.strIngredient3)
                                    TextoDescripcion(meal.strIngredient4)
                                    TextoDescripcion(meal.strIngredient5)

                                }
                            //}



                        }


                    }
                }


            }else{
                Text(text ="  no hay información acerca de este meal",
                    fontSize = 10.sp,
                    color = Color(0xFFE91E63),
                    overflow = TextOverflow.Ellipsis //como se maneja el desbordamiento
                )
            }

        }
    }


}