package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ranjan.myportfolio.data.models.FeaturedItem
import com.ranjan.myportfolio.presentation.components.cards.SkillCard
import com.ranjan.myportfolio.presentation.components.common.SectionTitle
import com.ranjan.myportfolio.presentation.design.DesignSystem

@Composable
fun ToolsSection(
    title: String,
    tools: List<FeaturedItem>,
    isLargeScreen: Boolean
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.xl)
    ) {
        SectionTitle(title)

        val columns = if (isLargeScreen) 2 else 1
        val chunkedTools = if (columns > 1) {
            tools.chunked((tools.size + columns - 1) / columns)
        } else {
            listOf(tools)
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.lg),
            modifier = Modifier.fillMaxWidth()
        ) {
            chunkedTools.forEach { toolGroup ->
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.lg)
                ) {
                    toolGroup.forEach { tool ->
                        SkillCard(tool)
                    }
                }
            }
        }
    }
}