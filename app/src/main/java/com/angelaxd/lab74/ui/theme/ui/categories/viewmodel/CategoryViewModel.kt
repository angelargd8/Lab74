package com.angelaxd.lab74.ui.theme.ui.categories.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angelaxd.lab74.ui.theme.networking.MealsApi
import com.angelaxd.lab74.ui.theme.networking.dto.CategoriesDto
import com.angelaxd.lab74.ui.theme.ui.categories.repository.CategoryRepositoryImpl
import kotlinx.coroutines.launch
import java.lang.Exception

class CategoryViewModel (
    private val repository: CategoryRepositoryImpl = CategoryRepositoryImpl(MealsApi.instance)
):ViewModel() {
    private val _state = MutableLiveData<CategoriesDto>()

    val listCategories: LiveData<CategoriesDto> = _state

    fun FetchCategories(){
        viewModelScope.launch{
            try {
                val categories = repository.getCategories()
                _state.value = categories

            }catch (e: Exception){
                Log.e("get error", e.message.toString())
            }
        }
    }


}