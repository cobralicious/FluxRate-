package com.example.buttonnavless.button_navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buttonnavless.R

@Composable
fun CurrencyCard(
    index: Int,
    currency: String,
    priceUsd: Double,
    priceInCurrency: Double,
    flagMap: Map<String, Int>
) {
    val flagRes = flagMap[currency] ?: R.drawable.settings

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${index + 1}.",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(start = 10.dp).width(32.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.width(20.dp))

            flagRes?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = "$currency flag",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
            }


            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = currency,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )

            Text(
                text = String.format("%.3f", priceUsd),
                modifier = Modifier
                    .padding(end = 5.dp)
                    .width(100.dp),
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.End
            )

            Text(
                text = String.format("%.3f$", priceInCurrency),
                modifier = Modifier
                    .padding(end = 20.dp)
                    .width(80.dp),
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.End
            )
        }
    }
}
