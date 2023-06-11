package com.example.composedocshredder.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.lang.Integer.min
import kotlin.random.Random

@Composable
fun EncryptionComponent(modifier: Modifier, animation: State<Float>) {
    val isShredding = remember(animation.value) {
        animation.value in 1f..2.5f
    }

    val encryptedText = remember {
        mutableStateOf(buildAnnotatedString {  })
    }

    fun generateRandomString(lengthOfString: Int): String {
        val allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        var randomString = ""
        for (i in 0..lengthOfString) {
            randomString += allChars[Random.nextInt(0, allChars.length)].toString()
        }
        return randomString
    }

     suspend fun startRandomGen() {
        while (isShredding) {
            val random = Random(System.currentTimeMillis())

            val shuffledCode = generateRandomString(800)

            val style = SpanStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color.White.copy(alpha = .5f),
                letterSpacing = 12.sp,
                fontFamily = FontFamily.Monospace
            )

            encryptedText.value = buildAnnotatedString {
                var start = 0
                var end = random.nextInt(30)
                while (end < shuffledCode.length) {
                    shuffledCode.substring(start..end).let {
                        withStyle(style) {
                            append(it)
                        }
                    }
                    if (end == shuffledCode.lastIndex) break
                    withStyle(style.copy(color = Color.White)) {
                        append(shuffledCode[++end])
                    }
                    start = end + 1
                    end = min(start + random.nextInt(20), shuffledCode.lastIndex)

                }
            }
            delay(250)
        }
    }

    LaunchedEffect(key1 = isShredding) {
        startRandomGen()
    }

    if (encryptedText.value.isNotEmpty()) {

        Box(
            modifier = modifier
                .height(410.dp)
                .width(550.dp)
        ) {
            Text(text = encryptedText.value, overflow = TextOverflow.Ellipsis)
        }
    }
}