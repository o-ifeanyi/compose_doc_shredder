package com.example.composedocshredder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composedocshredder.ui.pages.HomePage
import com.example.composedocshredder.ui.theme.ComposeDocShredderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDocShredderTheme(darkTheme = true) {
                HomePage()
            }
        }
    }
}