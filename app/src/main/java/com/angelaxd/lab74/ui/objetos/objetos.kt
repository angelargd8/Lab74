package com.angelaxd.lab74.ui.objetos

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.LocalContentColor
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
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun Texto(texto: String){

    Text(
        text = texto,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        //modifier = Modifier.padding()
        //modifier = Modifier.wrapContentHeight(),
        fontSize = 25.sp,
        color = Color(0xFF6200EE),
        fontWeight= FontWeight.Bold, //grosor del texto
        fontStyle = FontStyle.Italic, //estilo (normal, cursiva..)
        lineHeight = 17.sp, //altura de linea del texto
        overflow = TextOverflow.Ellipsis //como se maneja el desbordamiento
    )

}

@Composable
fun TextoDescripcion(texto: String){

    Text(
        text = texto,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        //modifier = Modifier.padding()
        //modifier = Modifier.wrapContentHeight(),
        fontSize = 15.sp,
        color = Color(0xFF6200EE),
        //fontWeight= FontWeight.Bold, //grosor del texto
        fontStyle = FontStyle.Normal, //estilo (normal, cursiva..)
        lineHeight = 17.sp, //altura de linea del texto
        overflow = TextOverflow.Ellipsis //como se maneja el desbordamiento
    )

}