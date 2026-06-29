package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FeatherIcons
import compose.icons.SimpleIcons
import compose.icons.feathericons.*
import compose.icons.simpleicons.*
import com.ranjan.myportfolio.data.models.ContactInfo
import com.ranjan.myportfolio.presentation.components.common.SectionTitleBody
import com.ranjan.myportfolio.presentation.design.DesignSystem

@Composable
fun ContactSection(
    contactInfo: ContactInfo,
    onClick: (String) -> Unit = {},
    isLargeScreen: Boolean
) {

    Column(verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.xl)) {
        SectionTitleBody("Contact Me")

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                    shape = DesignSystem.Cards.shape
                ),
            elevation = CardDefaults.cardElevation(defaultElevation = DesignSystem.Cards.defaultElevationDp),
            shape = DesignSystem.Cards.shape,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            )
        ) {
            Column(
                modifier = Modifier.padding(DesignSystem.Cards.padding),
                verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.md)
            ) {
                Text(
                    text = "Let's work together!",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "I'm always interested in new opportunities and exciting projects. Feel free to reach out!",
                    style = MaterialTheme.typography.bodyLarge,
                    lineHeight = 24.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(DesignSystem.Spacing.md))

                // Create list of available contact methods
                val contactMethods = buildList {
                    // Email (always available)
                    add(
                        ContactMethod(
                            icon = FeatherIcons.Mail,
                            label = "Email",
                            action = { onClick("mailto:${contactInfo.email}") }
                        )
                    )

                    // LinkedIn (always available)
                    add(
                        ContactMethod(
                            icon = SimpleIcons.Linkedin,
                            label = "LinkedIn",
                            action = { onClick(contactInfo.linkedin) }
                        )
                    )

                    // GitHub (always available)
                    add(
                        ContactMethod(
                            icon = SimpleIcons.Github,
                            label = "GitHub",
                            action = { onClick(contactInfo.github) }
                        )
                    )

                    // Twitter (only if available)
                    contactInfo.twitter?.let { twitterUrl ->
                        add(
                            ContactMethod(
                                icon = SimpleIcons.Twitter,
                                label = "Twitter",
                                action = { onClick(twitterUrl) }
                            )
                        )
                    }

                    // Medium (only if available)
                    contactInfo.medium.let { mediumUrl ->
                        add(
                            ContactMethod(
                                icon = SimpleIcons.Medium,
                                label = "Medium",
                                action = { onClick(mediumUrl) }
                            )
                        )
                    }
                }

                if (isLargeScreen) {
                    // Large screen - arrange in rows (2 columns)
                    val chunkedMethods = contactMethods.chunked(2)
                    Column(
                        verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.sm)
                    ) {
                        chunkedMethods.forEach { rowMethods ->
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.md),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                rowMethods.forEach { method ->
                                    OutlinedButton(
                                        onClick = method.action,
                                        modifier = Modifier.weight(1f),
                                        shape = DesignSystem.Cards.shape
                                    ) {
                                        Icon(
                                            imageVector = method.icon,
                                            contentDescription = method.label,
                                            modifier = Modifier.size(18.dp)
                                        )
                                        Spacer(modifier = Modifier.width(DesignSystem.Spacing.sm))
                                        Text(method.label)
                                    }
                                }
                                // Add empty space if odd number of methods in the row
                                if (rowMethods.size == 1) {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }
                        }
                    }
                } else {
                    // Small screen - single column layout
                    Column(
                        verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.sm)
                    ) {
                        contactMethods.forEach { method ->
                            OutlinedButton(
                                onClick = method.action,
                                modifier = Modifier.fillMaxWidth(),
                                shape = DesignSystem.Cards.shape
                            ) {
                                Icon(
                                    imageVector = method.icon,
                                    contentDescription = method.label,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(DesignSystem.Spacing.sm))
                                Text(method.label)
                            }
                        }
                    }
                }
            }
        }
    }
}

private data class ContactMethod(
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val label: String,
    val action: () -> Unit
)