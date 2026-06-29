package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.ranjan.myportfolio.data.models.Education
import com.ranjan.myportfolio.presentation.components.cards.EducationCard
import com.ranjan.myportfolio.presentation.components.common.SectionTitle
import com.ranjan.myportfolio.presentation.design.DesignSystem
import kotlinx.collections.immutable.PersistentList

@Composable
fun EducationSection(education: PersistentList<Education>, isLargeScreen: Boolean) {
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