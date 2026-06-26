package com.ranjan.myportfolio.presentation.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.presentation.design.DesignSystem
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.alert_circle
import myportfolio.composeapp.generated.resources.refresh_cw
import org.jetbrains.compose.resources.painterResource

@Composable
fun LoadingScreen() {
    val infiniteTransition = rememberInfiniteTransition(label = "loading")
    val scale by infiniteTransition.animateFloat(
        initialValue = 0.8f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.lg)
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(48.dp).scale(scale),
                strokeWidth = 4.dp,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Loading...",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun ErrorScreen(
    error: String,
    onRetry: () -> Unit,
    onDismiss: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(DesignSystem.Spacing.lg)
                .widthIn(max = DesignSystem.Layout.contentMaxWidth),
            elevation = CardDefaults.cardElevation(defaultElevation = DesignSystem.Cards.hoverElevationDp),
            shape = DesignSystem.Cards.shape,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(
                modifier = Modifier.padding(DesignSystem.Cards.padding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.lg)
            ) {
                Icon(
                    painter = painterResource(Res.drawable.alert_circle),
                    contentDescription = "Error",
                    modifier = Modifier.size(48.dp),
                    tint = MaterialTheme.colorScheme.error
                )

                Text(
                    text = "Oops! Something went wrong",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.error,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = error,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.md),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier.weight(1f),
                        shape = DesignSystem.Cards.shape
                    ) {
                        Text("Dismiss")
                    }
                    Button(
                        onClick = onRetry,
                        modifier = Modifier.weight(1f),
                        shape = DesignSystem.Cards.shape
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.refresh_cw),
                            contentDescription = "Retry",
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(DesignSystem.Spacing.xs))
                        Text("Retry")
                    }
                }
            }
        }
    }
}