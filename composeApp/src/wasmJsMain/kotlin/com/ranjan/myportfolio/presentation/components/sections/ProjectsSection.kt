package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ranjan.myportfolio.data.models.Project
import com.ranjan.myportfolio.presentation.components.cards.ProjectCard
import com.ranjan.myportfolio.presentation.components.common.SectionTitle
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
        SectionTitle("Projects")
        
        if (projects.isEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(DesignSystem.Cards.padding)
                        .fillMaxWidth(),
                    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "No projects available",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(DesignSystem.Spacing.sm))
                    Text(
                        text = "Projects will appear here once added to portfolio data",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                    )
                }
            }
        } else {
            val columns = if (isLargeScreen) 2 else 1
            val chunkedProjects = if (columns > 1 && projects.isNotEmpty()) {
                val chunkSize = (projects.size + columns - 1) / columns
                if (chunkSize > 0) {
                    projects.chunked(chunkSize)
                } else {
                    listOf(projects)
                }
            } else {
                listOf(projects)
            }
            
            Row(
                horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.lg),
                modifier = Modifier.fillMaxWidth()
            ) {
                chunkedProjects.forEach { projectGroup ->
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.lg)
                    ) {
                        projectGroup.forEach { project ->
                            ProjectCard(project, onClick)
                        }
                    }
                }
            }
        }
    }
}