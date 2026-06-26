package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ranjan.myportfolio.data.models.FeaturedItem
import com.ranjan.myportfolio.data.models.Skill
import com.ranjan.myportfolio.presentation.components.cards.SkillCard
import com.ranjan.myportfolio.presentation.components.common.SectionTitle
import com.ranjan.myportfolio.presentation.design.DesignSystem

@Composable
fun SkillsSection(skills: List<FeaturedItem>, isLargeScreen: Boolean) {
    Column(
        verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.xl)
    ) {
        SectionTitle("Skills")

        val columns = if (isLargeScreen) 2 else 1
        val chunkedSkills = if (columns > 1) {
            skills.chunked((skills.size + columns - 1) / columns)
        } else {
            listOf(skills)
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.lg),
            modifier = Modifier.fillMaxWidth()
        ) {
            chunkedSkills.forEach { skillGroup ->
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.lg)
                ) {
                    skillGroup.forEach { skill ->
                        SkillCard(skill)
                    }
                }
            }
        }
    }
}