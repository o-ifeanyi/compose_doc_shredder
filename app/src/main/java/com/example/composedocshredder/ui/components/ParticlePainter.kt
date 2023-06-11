package com.example.composedocshredder.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill

data class Particle(
    var x: Float,
    var y: Float,
    var r: Float, // radius
    var d: Float, // density
    var color: Color
)

@Composable
fun ParticlePainter(particles: List<Particle>) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        for (particle in particles) {
            val position = Offset(x = particle.x, y = particle.y)
            this.drawCircle(
                color = particle.color,
                radius = particle.r,
                center = position,
                style = Fill
            )
        }
    }
}