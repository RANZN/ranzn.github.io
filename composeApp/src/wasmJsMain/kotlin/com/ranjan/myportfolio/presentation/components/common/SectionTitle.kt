package com.ranjan.myportfolio.presentation.components.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun SectionTitle(
    line1: String,
    line2: String? = null,
    icon: ImageVector? = null,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start
    ) {
        icon?.let {
            Icon(imageVector = icon, contentDescription = line2)
        }
        Text(
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Black,
                        fontSize = 94.sp,
                    )
                ) {
                    append(line1)
                }
                line2?.let { line2 ->
                    appendLine()
                    withStyle(SpanStyle(color = Color.Gray, fontWeight = FontWeight.Black, fontSize = 90.sp)) {
                        append(line2)
                    }
                }
            },
            style = MaterialTheme.typography.displayLarge,
            lineHeight = 90.sp
        )
    }
}