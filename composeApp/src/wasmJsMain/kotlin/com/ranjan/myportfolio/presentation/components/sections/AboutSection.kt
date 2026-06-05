package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.myportfolio.presentation.design.DesignSystem
import com.ranjan.myportfolio.data.models.Article
import com.ranjan.myportfolio.data.models.ContactInfo
import com.ranjan.myportfolio.data.models.NavigationSection
import com.ranjan.myportfolio.data.models.Profile
import com.ranjan.myportfolio.data.models.Skill
import compose.icons.FeatherIcons
import compose.icons.SimpleIcons
import compose.icons.feathericons.ArrowRight
import compose.icons.simpleicons.Github
import compose.icons.simpleicons.Linkedin
import compose.icons.simpleicons.Medium
import compose.icons.simpleicons.Twitter

@Composable
fun AboutSection(
    profile: Profile,
    contactInfo: ContactInfo,
    skills: List<Skill>,
    articles: List<Article>,
    onSectionSelected: (NavigationSection) -> Unit,
    onClick: (String) -> Unit = {},
    isLargeScreen: Boolean
) {

    Column(verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.xl)) {
        // Profile Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = DesignSystem.Cards.defaultElevationDp),
            shape = DesignSystem.Cards.shape
        ) {
            Column(
                modifier = Modifier.padding(DesignSystem.Cards.padding),
                verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.md)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = profile.name,
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(DesignSystem.Spacing.xs))
                        Text(
                            text = profile.title,
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
                
                profile.aboutDescription.forEach { paragraph ->
                    Text(
                        text = paragraph,
                        style = MaterialTheme.typography.bodyLarge,
                        lineHeight = 24.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // Follow Me Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = DesignSystem.Cards.defaultElevationDp),
            shape = DesignSystem.Cards.shape,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            )
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f),
                        shape = DesignSystem.Cards.shape
                    ),
                shape = DesignSystem.Cards.shape,
                color = MaterialTheme.colorScheme.surface
            ) {
                Column(
                    modifier = Modifier.padding(DesignSystem.Cards.padding),
                    verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.md)
                ) {
                Text(
                    text = "Follow Me On",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                // Create list of available social media platforms
                val socialMediaPlatforms = buildList {
                    // LinkedIn (always available)
                    add(
                        SocialMediaPlatform(
                            icon = SimpleIcons.Linkedin,
                            label = "LinkedIn",
                            url = contactInfo.linkedin
                        )
                    )

                    // Medium (only if available)
                    contactInfo.medium?.let { mediumUrl ->
                        add(
                            SocialMediaPlatform(
                                icon = SimpleIcons.Medium,
                                label = "Medium",
                                url = mediumUrl
                            )
                        )
                    }

                    // Twitter (only if available)
                    contactInfo.twitter?.let { twitterUrl ->
                        add(
                            SocialMediaPlatform(
                                icon = SimpleIcons.Twitter,
                                label = "Twitter",
                                url = twitterUrl
                            )
                        )
                    }

                    // GitHub (always available)
                    add(
                        SocialMediaPlatform(
                            icon = SimpleIcons.Github,
                            label = "GitHub",
                            url = contactInfo.github
                        )
                    )
                }

                if (isLargeScreen) {
                    // Large screen - horizontal layout
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.md)
                    ) {
                        socialMediaPlatforms.forEach { platform ->
                            SocialMediaButton(
                                icon = platform.icon,
                                label = platform.label,
                                url = platform.url,
                                onClick = onClick,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                } else {
                    // Small screen - adaptive grid layout based on available platforms
                    val chunkedPlatforms = socialMediaPlatforms.chunked(2)
                    Column(
                        verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.sm)
                    ) {
                        chunkedPlatforms.forEach { rowPlatforms ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.sm)
                            ) {
                                rowPlatforms.forEach { platform ->
                                    SocialMediaButton(
                                        icon = platform.icon,
                                        label = platform.label,
                                        url = platform.url,
                                        onClick = onClick,
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                                // Add empty space if odd number of platforms in the row
                                if (rowPlatforms.size == 1) {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }
                        }
                    }
                }
                }
            }
        }

        // Skills Preview Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = DesignSystem.Cards.defaultElevationDp),
            shape = DesignSystem.Cards.shape
        ) {
            Column(
                modifier = Modifier.padding(DesignSystem.Cards.padding),
                verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.md)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Top Skills",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    TextButton(
                        onClick = { onSectionSelected(NavigationSection.SKILLS) }
                    ) {
                        Text("View More")
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(FeatherIcons.ArrowRight, contentDescription = "View More", modifier = Modifier.size(16.dp))
                    }
                }
                
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.sm)
                ) {
                    items(skills.take(5)) { skill ->
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            ),
                            shape = DesignSystem.Cards.shape
                        ) {
                            Row(
                                modifier = Modifier.padding(DesignSystem.Spacing.md),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.sm)
                            ) {
                                Icon(
                                    imageVector = skill.icon,
                                    contentDescription = skill.name,
                                    modifier = Modifier.size(20.dp),
                                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                                Text(
                                    text = skill.name,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        }
                    }
                }
            }
        }

        // Articles Preview Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = DesignSystem.Cards.defaultElevationDp),
            shape = DesignSystem.Cards.shape
        ) {
            Column(
                modifier = Modifier.padding(DesignSystem.Cards.padding),
                verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.md)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Latest Articles",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    TextButton(
                        onClick = { onSectionSelected(NavigationSection.ARTICLES) }
                    ) {
                        Text("View More")
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(FeatherIcons.ArrowRight, contentDescription = "View More", modifier = Modifier.size(16.dp))
                    }
                }
                
                Column(
                    verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.sm)
                ) {
                    articles.take(2).forEach { article ->
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceVariant
                            ),
                            modifier = Modifier.fillMaxWidth(),
                            shape = DesignSystem.Cards.shape
                        ) {
                            Column(
                                modifier = Modifier.padding(DesignSystem.Spacing.md),
                                verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.sm)
                            ) {
                                Text(
                                    text = article.title,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.SemiBold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = article.summary,
                                    style = MaterialTheme.typography.bodyMedium,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.sm),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = article.date,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Text("•", color = MaterialTheme.colorScheme.onSurfaceVariant)
                                    Text(
                                        text = article.readTime,
                                        style = MaterialTheme.typography.bodySmall,
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
}

private data class SocialMediaPlatform(
    val icon: ImageVector,
    val label: String,
    val url: String
)

@Composable
private fun SocialMediaButton(
    icon: ImageVector,
    label: String,
    url: String,
    onClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = { onClick(url) },
        modifier = modifier.height(56.dp),
        contentPadding = PaddingValues(DesignSystem.Spacing.md),
        shape = DesignSystem.Cards.shape
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.xs)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Medium
            )
        }
    }
}