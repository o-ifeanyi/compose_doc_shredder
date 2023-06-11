package com.example.composedocshredder.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.composedocshredder.R

@Composable
fun PassportComponent(modifier: Modifier) {

    Box(modifier = modifier.fillMaxWidth()) {
        Surface(
            modifier = modifier
                .width(550.dp)
                .height(410.dp),
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.tertiary
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "PASSPORT", fontWeight = FontWeight.Bold)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier.height(250.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sample_passport_photo),
                        contentDescription = "Passport Photo",
                        modifier = Modifier.fillMaxHeight(),
                        contentScale = ContentScale.Fit
                    )

                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        PassportInfo(title = "SURNAME", subtitle = "DOE")
                        PassportInfo(title = "FIRST NAME", subtitle = "JOHN")
                        PassportInfo(title = "NATIONALITY", subtitle = "INDIAN")
                        PassportInfo(title = "DATE OF ISSUE", subtitle = "21 JUNE 2019")
                    }

                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        PassportInfo(title = "", subtitle = "")
                        PassportInfo(title = "CARD NUMBER", subtitle = "IN0453F563")
                        PassportInfo(title = "DATE OF BIRTH", subtitle = "12 APRIL 1999")
                        PassportInfo(title = "EXPIRATION", subtitle = "20 JUNE 2024")
                    }
                }

                Text(text = "PIN0453F563<<<<DOE<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<")
                Text(text = "599IR345<<<<JOHN<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<")
            }
        }
    }
}

@Composable
fun PassportInfo(title: String, subtitle: String) {
    Column {
        Text(text = title)
        Text(text = subtitle, fontWeight = FontWeight.Bold)
    }
}
