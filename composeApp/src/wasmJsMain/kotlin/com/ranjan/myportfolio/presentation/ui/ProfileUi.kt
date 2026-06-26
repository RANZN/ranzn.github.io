package com.ranjan.myportfolio.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.data.models.Profile
import com.ranjan.myportfolio.presentation.components.common.SocialMediaButton
import com.ranjan.myportfolio.presentation.design.DesignSystem
import kotlinx.collections.immutable.PersistentList
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProfileUi(
    profile: Profile,
    mediaPlatforms: PersistentList<SocialMediaPlatform>,
    modifier: Modifier = Modifier,
    onPlatformClick: (String) -> Unit,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = DesignSystem.Cards.defaultElevationDp),
        colors = CardDefaults.cardColors(containerColor = Color.White, contentColor = Color.Black),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.padding(horizontal = 50.dp, vertical = 40.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = DesignSystem.Cards.defaultElevationDp),
            ) {
                Image(
                    painter = painterResource(profile.profileImageRes),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                )
            }
            Text(
                profile.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                profile.title,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )

            Row(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally)
            ) {
                mediaPlatforms.forEach { platform ->
                    SocialMediaButton(
                        icon = platform.icon,
                        label = platform.label,
                        url = platform.url,
                        onClick = onPlatformClick,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}