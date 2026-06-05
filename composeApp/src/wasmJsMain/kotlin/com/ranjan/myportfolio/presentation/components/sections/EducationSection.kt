package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import com.ranjan.myportfolio.data.models.Education
import com.ranjan.myportfolio.presentation.components.cards.EducationCard
import com.ranjan.myportfolio.presentation.components.common.SectionTitle
import com.ranjan.myportfolio.presentation.design.DesignSystem

@Composable
fun EducationSection(education: List<Education>, isLargeScreen: Boolean) {
    Column(
        verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.xl)
    ) {
        SectionTitle("Education")
        
        Column(
            verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.lg)
        ) {
            education.forEach { edu ->
                EducationCard(edu)
            }
        }
    }
}