package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import com.ranjan.myportfolio.data.models.Article
import com.ranjan.myportfolio.presentation.components.cards.ArticleCard
import com.ranjan.myportfolio.presentation.components.common.SectionTitle
import com.ranjan.myportfolio.presentation.design.DesignSystem

@Composable
fun ArticlesSection(
    articles: List<Article>,
    onClick: (String) -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.xl)
    ) {
        SectionTitle("Articles")
        
        Column(
            verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.lg)
        ) {
            articles.forEach { article ->
                ArticleCard(article, onClick)
            }
        }
    }
}