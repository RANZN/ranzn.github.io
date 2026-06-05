package com.ranjan.myportfolio.presentation.components.cards

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.myportfolio.data.models.Education
import com.ranjan.myportfolio.presentation.design.DesignSystem
import compose.icons.FeatherIcons
import compose.icons.feathericons.BookOpen

@Composable
fun EducationCard(education: Education) {
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = DesignSystem.Cards.defaultElevationDp),
        shape = DesignSystem.Cards.shape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Row(
            modifier = Modifier
                .padding(DesignSystem.Cards.padding)
                .fillMaxWidth()
        ) {
            // Icon column
            Column(
                modifier = Modifier.padding(end = DesignSystem.Spacing.lg),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    shape = DesignSystem.Cards.shape,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    modifier = Modifier.size(48.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = FeatherIcons.BookOpen,
                            contentDescription = "Education",
                            modifier = Modifier.size(24.dp),
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
            
            // Content column
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = education.degree,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                
                Spacer(modifier = Modifier.height(DesignSystem.Spacing.xs))
                
                Text(
                    text = education.institution,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )
                
                Spacer(modifier = Modifier.height(DesignSystem.Spacing.sm))
                
                Row(
                    horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.md),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = education.year,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.Medium
                    )
                    if (education.gpa != null) {
                        Text(
                            text = "•",
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Surface(
                            shape = DesignSystem.Cards.shape,
                            color = MaterialTheme.colorScheme.tertiaryContainer
                        ) {
                            Text(
                                text = "GPA: ${education.gpa}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(
                                    horizontal = DesignSystem.Spacing.sm,
                                    vertical = DesignSystem.Spacing.xs
                                )
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(DesignSystem.Spacing.md))
                
                Text(
                    text = education.description,
                    style = MaterialTheme.typography.bodyMedium,
                    lineHeight = 24.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}