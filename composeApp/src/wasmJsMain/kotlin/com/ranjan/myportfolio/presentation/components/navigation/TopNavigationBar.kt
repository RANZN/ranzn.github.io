package com.ranjan.myportfolio.presentation.components.navigation

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FeatherIcons
import compose.icons.feathericons.*
import com.ranjan.myportfolio.data.models.NavigationSection
import com.ranjan.myportfolio.presentation.design.DesignSystem

@Composable
fun TopNavigationBar(
    navigationSections: List<NavigationSection>,
    selectedSection: () -> NavigationSection,
    onSectionSelected: (NavigationSection) -> Unit,
    isCompact: Boolean,
    isDarkMode: Boolean,
    onToggleDarkMode: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = DesignSystem.Elevation.xl
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = DesignSystem.Spacing.md, vertical = DesignSystem.Spacing.sm),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Navigation items
            if (isCompact) {
                // Compact mode - scrollable horizontal navigation
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.sm)
                ) {
                    navigationSections.forEach { section ->
                        CompactNavigationItem(
                            section = section,
                            isSelected = selectedSection() == section,
                            onClick = { onSectionSelected(section) }
                        )
                    }
                }
            } else {
                // Full mode - centered navigation
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.lg),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        navigationSections.forEach { section ->
                            FullNavigationItem(
                                section = section,
                                isSelected = selectedSection() == section,
                                onClick = { onSectionSelected(section) }
                            )
                        }
                    }
                }
            }
            
            // Dark mode toggle
            IconButton(
                onClick = onToggleDarkMode,
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    imageVector = if (isDarkMode) FeatherIcons.Sun else FeatherIcons.Moon,
                    contentDescription = if (isDarkMode) "Light Mode" else "Dark Mode",
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Composable
private fun CompactNavigationItem(
    section: NavigationSection,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        Color.Transparent
    }
    
    val contentColor = if (isSelected) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        MaterialTheme.colorScheme.onSurface
    }

    Surface(
        onClick = onClick,
        modifier = Modifier.height(40.dp),
        color = backgroundColor,
        shape = DesignSystem.Cards.shape
    ) {
        Row(
            modifier = Modifier.padding(horizontal = if (isSelected) DesignSystem.Spacing.md else DesignSystem.Spacing.sm),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(if (isSelected) DesignSystem.Spacing.sm else 0.dp)
        ) {
            Icon(
                imageVector = section.icon,
                contentDescription = section.title,
                modifier = Modifier.size(16.dp),
                tint = contentColor
            )
            
            // Show text only when selected in compact mode
            if (isSelected) {
                Text(
                    text = section.title,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.SemiBold,
                    color = contentColor
                )
            }
        }
    }
}

@Composable
private fun FullNavigationItem(
    section: NavigationSection,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val textColor = if (isSelected) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.primary.copy(alpha = 0.7f) // Use primary color instead of onSurface
    }

    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.textButtonColors(
            contentColor = textColor
        ),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.sm)
        ) {
            Icon(
                imageVector = section.icon,
                contentDescription = section.title,
                modifier = Modifier.size(18.dp),
                tint = textColor
            )
            Text(
                text = section.title,
                fontSize = 16.sp,
                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                letterSpacing = 0.5.sp
            )
        }
    }
}