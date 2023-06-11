package com.example.composedocshredder.ui.pages

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.composedocshredder.ui.components.BackgroundComponent
import com.example.composedocshredder.ui.components.EncryptionComponent
import com.example.composedocshredder.ui.components.PassportComponent
import com.example.composedocshredder.ui.components.ShredderComponent

@Composable
fun HomePage() {
    val config = LocalConfiguration.current

    val controller = rememberInfiniteTransition()
    val animation = controller.animateFloat(
        initialValue = -1.75f,
        targetValue = 4.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
    )

    Scaffold {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            BackgroundComponent()

            Box(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .offset(x = -(config.screenWidthDp / 2).dp, y = 0.dp),
            ) {
                EncryptionComponent(
                    modifier = Modifier.align(BiasAlignment(animation.value, 0f)),
                    animation = animation
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .offset(x = -(config.screenWidthDp / 2).dp, y = 0.dp)
                    .clipToBounds(),
            ) {
                PassportComponent(
                    modifier = Modifier
                        .align(BiasAlignment(animation.value, 0f)),
                )
            }

            ShredderComponent(color = MaterialTheme.colorScheme.primary)
        }
    }
}
