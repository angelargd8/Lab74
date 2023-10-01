package com.angelaxd.lab74.ui.theme.networking

import com.angelaxd.lab74.ui.theme.networking.dto.CategoriesDto
import com.angelaxd.lab74.ui.theme.ui.categories.viewmodel.Category
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface MealsApi {
    companion object{
        val instance = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder().build()).build().create(MealsApi::class.java)
    }
    @GET("categories.php")
    suspend fun getCategories(): CategoriesDto
}