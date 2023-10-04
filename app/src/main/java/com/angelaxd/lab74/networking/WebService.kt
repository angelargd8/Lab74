package com.angelaxd.lab74.networking

import com.angelaxd.lab74.networking.dto.CategoriesDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealWebService {

    //guardar la instancia
    private lateinit var api: MealsApi

    //inicializar dependencias
    init {
        //se crea la instancia retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //se guarda en api
        api = retrofit.create(MealsApi::class.java)
    }

    suspend fun getMealsCategories():CategoriesDto{
        //se manda a llamar las categorias "(categories.php)"
        return api.getCategories()
    }


}