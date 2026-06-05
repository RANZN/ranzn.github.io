package com.ranjan.myportfolio.presentation.components.cards

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.myportfolio.data.models.Article
import com.ranjan.myportfolio.presentation.design.DesignSystem
import compose.icons.FeatherIcons
import compose.icons.feathericons.ExternalLink

@Composable
fun ArticleCard(
    article: Article,
    onClick: (String) -> Unit = {}
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = DesignSystem.Cards.defaultElevationDp),
        shape = DesignSystem.Cards.shape,
        onClick = { onClick(article.link) },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Column(
            modifier = Modifier
                .padding(DesignSystem.Cards.padding)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = article.title,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = FeatherIcons.ExternalLink,
                    contentDescription = "Read article",
                    modifier = Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            
            Spacer(modifier = Modifier.height(DesignSystem.Spacing.md))
            
            Text(
                text = article.summary,
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 24.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            Spacer(modifier = Modifier.height(DesignSystem.Spacing.lg))
            
            Row(
                horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.md),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = article.date,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "•",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = article.readTime,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            if (article.tags.isNotEmpty()) {
                Spacer(modifier = Modifier.height(DesignSystem.Spacing.md))
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.xs)
                ) {
                    items(article.tags) { tag ->
                        FilterChip(
                            selected = false,
                            onClick = { },
                            label = { 
                                Text(
                                    tag, 
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Medium
                                ) 
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                labelColor = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        )
                    }
                }
            }
        }
    }
}