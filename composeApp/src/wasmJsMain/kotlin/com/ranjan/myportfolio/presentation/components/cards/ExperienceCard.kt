package com.ranjan.myportfolio.presentation.components.cards

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.myportfolio.data.models.Experience
import com.ranjan.myportfolio.presentation.design.DesignSystem
import compose.icons.FeatherIcons
import compose.icons.feathericons.Briefcase
import compose.icons.feathericons.Calendar
import compose.icons.feathericons.MapPin

@Composable
fun ExperienceCard(experience: Experience) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = DesignSystem.Cards.defaultElevationDp
        ),
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

            // Company Icon
            Column(
                modifier = Modifier.padding(end = DesignSystem.Spacing.lg),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    modifier = Modifier.size(48.dp),
                    shape = DesignSystem.Cards.shape,
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = FeatherIcons.Briefcase,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = experience.role,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(DesignSystem.Spacing.xs))

                Text(
                    text = experience.company,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(Modifier.height(DesignSystem.Spacing.sm))

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.sm),
                    verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.xs)
                ) {

                    ExperienceChip(
                        FeatherIcons.Calendar,
                        "${experience.startDate} - ${if (experience.isCurrent) "Present" else experience.endDate}"
                    )

                    ExperienceChip(
                        FeatherIcons.MapPin,
                        experience.location
                    )

                    ExperienceChip(
                        FeatherIcons.Briefcase,
                        experience.employmentType
                    )
                }

                experience.description.takeIf { it.isNotBlank() }?.let {
                    Spacer(Modifier.height(DesignSystem.Spacing.md))
                    Text(
                        text = experience.description,
                        style = MaterialTheme.typography.bodyMedium,
                        lineHeight = 24.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }


                if (experience.technologies.isNotEmpty()) {

                    Spacer(Modifier.height(DesignSystem.Spacing.lg))

                    Text(
                        text = "Technologies",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(DesignSystem.Spacing.sm))

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.sm)
                    ) {
                        experience.technologies.forEach { tech ->
                            SuggestionChip(
                                onClick = {},
                                label = { Text(tech) }
                            )
                        }
                    }
                }

                if (experience.highlights.isNotEmpty()) {

                    Spacer(Modifier.height(DesignSystem.Spacing.lg))

                    Text(
                        text = "Highlights",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(DesignSystem.Spacing.sm))

                    Column(
                        verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.sm)
                    ) {
                        experience.highlights.forEach { highlight ->
                            Row(
                                verticalAlignment = Alignment.Top
                            ) {

                                Text(
                                    text = "•",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.primary
                                )

                                Spacer(Modifier.width(DesignSystem.Spacing.sm))

                                Text(
                                    text = highlight,
                                    modifier = Modifier.weight(1f),
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ExperienceChip(
    icon: ImageVector,
    text: String
) {
    Surface(
        shape = RoundedCornerShape(50),
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = DesignSystem.Spacing.sm,
                vertical = DesignSystem.Spacing.xs
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(14.dp),
                tint = MaterialTheme.colorScheme.onSecondaryContainer
            )

            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.Medium
            )
        }
    }
}