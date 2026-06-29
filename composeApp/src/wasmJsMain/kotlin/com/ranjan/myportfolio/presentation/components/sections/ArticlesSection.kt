package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.presentation.components.LoadingScreen
import com.ranjan.myportfolio.presentation.components.cards.ArticleCard
import com.ranjan.myportfolio.presentation.components.common.SectionTitleBody
import com.ranjan.myportfolio.presentation.design.DesignSystem
import com.ranjan.myportfolio.presentation.ui.ArticlesState
import compose.icons.SimpleIcons
import compose.icons.simpleicons.Medium

@Composable
fun ArticlesSection(
    articlesState: ArticlesState,
    onClick: (String) -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.xl)
    ) {
        SectionTitleBody("Articles")

        when (articlesState) {
            is ArticlesState.Error -> {
                ArticlesMoreButton(
                    text = "Failed to get Articles, Check All Articles on Medium -->",
                    onClick = { onClick(articlesState.mediumUrl) })
            }

            ArticlesState.Loading -> {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = DesignSystem.Cards.defaultElevationDp),
                    shape = DesignSystem.Cards.shape,
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    )
                ) {
                    LoadingScreen(modifier = Modifier.padding(vertical = 40.dp))
                }
            }

            is ArticlesState.Success -> {
                Column(
                    verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.lg)
                ) {
                    articlesState.articles.forEach { article ->
                        ArticleCard(article, onClick)
                    }
                    ArticlesMoreButton(text = "Check All Articles -->", onClick = { onClick(articlesState.mediumUrl) })
                }
            }
        }
    }
}

@Composable
fun ArticlesMoreButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = DesignSystem.Cards.defaultElevationDp),
        shape = DesignSystem.Cards.shape,
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = SimpleIcons.Medium,
                contentDescription = "Check All Articles -->",
                modifier = Modifier.padding(16.dp).size(40.dp),
            )
            Text(text)
        }
    }
}