package com.ranjan.myportfolio.presentation.components.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.presentation.design.DesignSystem
import com.ranjan.myportfolio.data.models.NavigationSection
import com.ranjan.myportfolio.data.models.Profile
import compose.icons.FeatherIcons
import compose.icons.feathericons.ChevronLeft
import compose.icons.feathericons.Moon
import compose.icons.feathericons.Sun
import org.jetbrains.compose.resources.painterResource

@Composable
fun NavigationSidebar(
    profile: Profile,
    navigationSections: List<NavigationSection>,
    selectedSection: () -> NavigationSection,
    onSectionSelected: (NavigationSection) -> Unit,
    isCollapsed: Boolean,
    onToggleCollapse: () -> Unit,
    isDarkMode: Boolean,
    onToggleDarkMode: () -> Unit,
    modifier: Modifier = Modifier
) {
    val rotationAngle by animateFloatAsState(
        targetValue = if (isCollapsed) 180f else 0f,
        animationSpec = tween(300)
    )

    Surface(
        modifier = modifier.fillMaxHeight(),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = DesignSystem.Elevation.lg
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(DesignSystem.Spacing.md),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.md)
        ) {
            // Header with collapse toggle
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Collapse toggle
                IconButton(
                    onClick = onToggleCollapse,
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        imageVector = FeatherIcons.ChevronLeft,
                        contentDescription = if (isCollapsed) "Expand" else "Collapse",
                        modifier = Modifier.rotate(rotationAngle),
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
            AnimatedContent(
                targetState = isCollapsed,
                transitionSpec = {
                    fadeIn() togetherWith fadeOut()
                }
            ) { isCollapsedState ->
                if (!isCollapsedState) {
                    // Profile section
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.sm)
                    ) {
                        // Profile picture
                        Image(
                            painter = painterResource(profile.profileImageRes),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(80.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = profile.name,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Text(
                            text = profile.title,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
                } else {
                    // Collapsed profile - just profile picture
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Image(
                            painter = painterResource(profile.profileImageRes),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }

            // Navigation items
            Column(
                verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.sm)
            ) {
                navigationSections.forEach { section ->
                    NavigationItem(
                        section = section,
                        isSelected = selectedSection() == section,
                        onClick = { onSectionSelected(section) },
                        isCollapsed = isCollapsed
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // Dark mode toggle
            if (!isCollapsed) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Dark Mode",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Switch(
                        checked = isDarkMode,
                        onCheckedChange = { onToggleDarkMode() }
                    )
                }
            } else {
                // Collapsed dark mode toggle - just icon
                IconButton(
                    onClick = onToggleDarkMode,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Icon(
                        imageVector = if (isDarkMode) FeatherIcons.Sun else FeatherIcons.Moon,
                        contentDescription = "Toggle Dark Mode",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}

@Composable
private fun NavigationItem(
    section: NavigationSection,
    isSelected: Boolean,
    onClick: () -> Unit,
    isCollapsed: Boolean
) {
    val backgroundColor = if (isSelected) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        Color.Transparent
    }

    val contentColor = if (isSelected) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        MaterialTheme.colorScheme.primary.copy(alpha = 0.8f) // Use primary color for icons when not selected
    }
    
    val textColor = if (isSelected) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        MaterialTheme.colorScheme.onSurface
    }

    Surface(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        color = backgroundColor,
        shape = DesignSystem.Cards.shape
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = if (isCollapsed) DesignSystem.Spacing.sm else DesignSystem.Spacing.md),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = if (isCollapsed) Arrangement.Center else Arrangement.Start
        ) {
            Icon(
                imageVector = section.icon,
                contentDescription = section.title,
                modifier = Modifier.size(20.dp),
                tint = contentColor
            )

            if (!isCollapsed) {
                Spacer(modifier = Modifier.width(DesignSystem.Spacing.sm))
                Text(
                    text = section.title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                    color = textColor
                )
            }
        }
    }
}