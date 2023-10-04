package com.angelaxd.lab74.networking

import com.angelaxd.lab74.networking.dto.CategoriesDto
import com.angelaxd.lab74.networking.dto.FilterDto
import com.angelaxd.lab74.networking.dto.MealsDto
import com.angelaxd.lab74.ui.categories.viewmodel.Category
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface MealsApi {
    //aqui solo gets y post

    /** categorias **/
    @GET("categories.php")
    //corrutina y se le dice que tipo de dato
    suspend fun getCategories(): CategoriesDto

    /** filtros **/
    @GET("filter.php?c=Seafood")
    suspend fun getFilter(): FilterDto


    /** Meals **/
    @GET("lookup.php?i=52944")
    suspend fun getLookUp(): MealsDto
}