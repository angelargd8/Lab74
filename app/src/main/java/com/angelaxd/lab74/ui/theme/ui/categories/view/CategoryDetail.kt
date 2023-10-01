package com.angelaxd.lab74.ui.theme.ui.categories.view

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.angelaxd.lab74.ui.theme.ui.objetos.Texto

//id: String?, str: String?, description: String?, thumb: String?
@Composable
fun CategoryDetail(
    navController: NavHostController,
    id: String? // ?=opcional

) {

    Log.d(ContentValues.TAG, "---BANDERAAAAAAAAAAA---");
    Log.d(ContentValues.TAG, id.toString());
    Texto("Category Detail")
    //comprobarque existe
    id?.let {
        Texto(id)
        //Texto("id")
    }

    //Column() {


        //Texto(str)
        //Texto(description)
        //Texto(thumb)
    //}

}