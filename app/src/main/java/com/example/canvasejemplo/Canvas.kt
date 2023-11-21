package com.example.canvasejemplo

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun completo (){
    Scaffold(topBar = { MyTopAppBar() }) {
        Box(modifier = Modifier.padding(top = it.calculateTopPadding())) {
            canvas()
        }
    }
}
@Composable
fun canvas() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val mySize= 50f
        val myMargin = 50f

        // Rectángulo en la esquina superior izquierda
        drawRect(
            color = Color.Green,
            topLeft = Offset(x = myMargin, y = myMargin),
            size = Size(width = mySize, height = mySize)
        )

        // Rectángulo en la esquina superior derecha
        drawRect(
            color = Color.Gray,
            topLeft = Offset(x = size.width - myMargin - mySize, y = myMargin),
            size = Size(width = mySize, height = mySize)
        )

        // Rectángulo en la esquina inferior izquierda
        drawRect(
            color = Color.Yellow,
            topLeft = Offset(x = myMargin, y = size.width - myMargin - mySize),
            size = Size(width = mySize, height = mySize)
        )

        // Rectángulo en la esquina inferior derecha
        drawRect(
            color = Color.Red,
            topLeft = Offset(x = size.width - myMargin - mySize, y = size.width - myMargin - mySize),
            size = Size(width = mySize, height = mySize)
        )

        // Círculo en el centro sin relleno
        drawCircle(
            color = Color.Blue,
            center = Offset(x = size.width / 2, y = size.width / 2),
            radius = 150.dp.toPx(),
            style = Stroke(width = 2.dp.toPx()) //sin relleno
        )

        // Punto en el centro del canvas
        drawPoints(
            points = listOf(Offset(size.width / 2, size.width / 2)),
            pointMode = PointMode.Points,
            color = Color.Magenta,
            strokeWidth = mySize/2
        )

    }
}
