@file:JvmName("EncryptionComponentKt")

package com.example.composedocshredder.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp

@Composable
fun ShredderComponent(color: Color) {
    Canvas(modifier = Modifier
        .width(20.dp)
        .height(450.dp)) {
        val centerWidth = 40
        val width = size.width
        val height = size.height

        this.drawIntoCanvas {
            val shadowColor = color.copy(alpha = 0.6f).toArgb()
            val transparentColor = color.copy(alpha = 0f).toArgb()

            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            frameworkPaint.color = transparentColor
            frameworkPaint.setShadowLayer(
                16.dp.toPx(), // blur radius
                5.dp.toPx(), // x offset
                5.dp.toPx(), // y offset
                shadowColor
            )
            it.drawRoundRect(
                50f,
                0f,
                -25f,
                this.size.height,
                20.dp.toPx(),
                20.dp.toPx(),
                paint
            )
        }


        val path = Path()
        path.moveTo(width / 2, height)
        path.quadraticBezierTo(
            width / 2 - centerWidth / 2, height / 2,
            width / 2, height
        )
        path.quadraticBezierTo(
            width / 2 + centerWidth / 2, height / 2,
            width / 2, 0f
        )
        path.close()

        this.drawPath(path = path, color = Color.White)
    }
}
