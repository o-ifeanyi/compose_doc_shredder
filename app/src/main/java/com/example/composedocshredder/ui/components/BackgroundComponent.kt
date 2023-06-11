package com.example.composedocshredder.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

@Composable
fun BackgroundComponent() {
    val config = LocalConfiguration.current

    val particles = remember {
        mutableStateOf(mutableListOf<Particle>())
    }
    val speed = 20
    val controller = rememberInfiniteTransition()
    val animation = controller.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            tween(),
            repeatMode = RepeatMode.Restart
        ),
    )

    fun createParticles() {
        particles.value = mutableListOf()
        for (i in 0..400) {
            particles.value.add(
                Particle(
                    x = Random.nextFloat() * config.screenWidthDp,
                    y = Random.nextFloat() * (config.screenHeightDp * 2),
                    r = Random.nextFloat() * 2.5f + 1,
                    d = Random.nextFloat() * speed,
                    color = Color.White.copy(alpha = Random.nextFloat())
                )
            )
        }
    }

    fun update() {
        if (particles.value.isEmpty()) {
            createParticles()
        }
        for (i in 0 until particles.value.size) {
            val particle = particles.value[i]


            particle.x +=
                (cos(particle.d) + 1 + particle.r / 2) * speed
            particle.y += (sin(0.0) * 2).toFloat() * speed

            if (particle.x > config.screenWidthDp * 2) {

                particles.value[i] = Particle(
                    x = Random.nextFloat() * config.screenWidthDp,
                    y = Random.nextFloat() * (config.screenHeightDp * 2),
                    r = Random.nextFloat() * 2.5f + 1,
                    d = Random.nextFloat() * speed,
                    color = Color.White.copy(alpha = Random.nextFloat())
                )
            }
        }
    }

    LaunchedEffect(key1 = animation.value) {
        update()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        ParticlePainter(particles = particles.value)
    }
}