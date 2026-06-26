package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.ranjan.myportfolio.data.models.Project
import com.ranjan.myportfolio.presentation.components.cards.ProjectCard
import com.ranjan.myportfolio.presentation.design.DesignSystem

@Composable
fun ProjectsSection(
    projects: List<Project>,
    onClick: (String) -> Unit = {},
    isLargeScreen: Boolean
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.xl)
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 94.sp,
                    )
                ) {
                    append("RECENT\n")
                }

                withStyle(
                    SpanStyle(
                        color = Color.Gray,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 90.sp
                    )
                ) {
                    append("PROJECTS")
                }
            },
            style = MaterialTheme.typography.displayLarge,
            lineHeight = 90.sp
        )

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.lg),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.lg),
            maxItemsInEachRow = if (isLargeScreen) 2 else 1
        ) {
            projects.forEach { project ->
                ProjectCard(
                    project = project,
                    modifier = Modifier.fillMaxWidth(if (isLargeScreen) 0.48f else 1f),
                    onClick = onClick
                )
            }
        }
    }
}