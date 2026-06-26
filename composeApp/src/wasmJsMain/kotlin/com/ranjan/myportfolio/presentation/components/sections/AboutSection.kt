package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.myportfolio.data.models.Profile
import com.ranjan.myportfolio.presentation.design.DesignSystem
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AboutSection(profile: Profile) {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = DesignSystem.Spacing.xs),
            elevation = CardDefaults.cardElevation(defaultElevation = DesignSystem.Cards.defaultElevationDp),
            shape = DesignSystem.Cards.shape,
            colors = CardDefaults.cardColors(containerColor = Color.Black.copy(alpha = 0.8f))
        ) {
            val roleText = remember(profile.role) {
                val role = profile.role.split(" ")

                buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            color = Color.White,
                            fontSize = 120.sp
                        )
                    ) {
                        append(role.first())
                    }

                    role.drop(1).forEach {
                        withStyle(
                            SpanStyle(
                                color = Color.Gray,
                                fontSize = 110.sp
                            )
                        ) {
                            append("\n")
                            append(it)
                        }
                    }
                }
            }
            Text(
                text = roleText,
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 100.sp,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(DesignSystem.Spacing.xl))

            Text(
                text = profile.aboutDescription,
                style = MaterialTheme.typography.bodyLarge,
                lineHeight = 24.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.widthIn(max = 500.dp)
            )
        }
    }


}

@Preview
@Composable
fun AboutSectionPreview() {
    val profile = remember { Profile() }
    AboutSection(profile)
}