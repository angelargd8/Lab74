package com.angelaxd.lab74.ui.categories.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angelaxd.lab74.networking.MealsApi
import com.angelaxd.lab74.networking.dto.CategoriesDto
import com.angelaxd.lab74.networking.dto.CategoryDto
import com.angelaxd.lab74.ui.categories.repository.CategoryRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class CategoryViewModel (

    private val respository: CategoryRepositoryImpl = CategoryRepositoryImpl()

):ViewModel() {
    // el estado puede ser manejado de varias formas como el livedata, mutable state etc
    /** mutable state **/
    //cuando el estado cambia el ui cambia tmb
    //la lista de categorias es lo que va a mantener el estado
    //categoriesState --> variable que va a mantener el estado
    val categoriesState: MutableState<List<CategoryDto>> = mutableStateOf(emptyList<CategoryDto>())

    //se inicializa, momento en el que se crea view model
    init {
        //scope: determina el tiempo de vida de la corrutina
        viewModelScope.launch(Dispatchers.IO) {//lo de (Dispatchers.IO), usualmente se usa en base de datos
            //se manda a llamar al metodo del repositorio (el de abajo)
            val meals = getCategories()
            categoriesState.value = meals

        }
    }

    //llama al repositorio y obtiene las categorias
    private suspend fun getCategories(): List<CategoryDto>{
        return respository.getCategories().categories
    }






}