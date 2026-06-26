package com.ranjan.myportfolio.presentation.ui

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector
import com.ranjan.myportfolio.data.models.NavigationSection
import com.ranjan.myportfolio.domain.models.PortfolioState
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList


@Stable
data class PortfolioUiState(
    val portfolioState: PortfolioState = PortfolioState(),
    val selectedSection: NavigationSection = NavigationSection.ABOUT,
    val navigationSections: PersistentList<NavigationSection> = NavigationSection.entries.toPersistentList(),
    val isDarkMode: Boolean = true,
    val isNavigationCollapsed: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)

@Stable
data class SocialMediaPlatform(
    val icon: ImageVector,
    val label: String,
    val url: String
)

@Immutable
sealed class PortfolioIntent {
    data object LoadPortfolioData : PortfolioIntent()
    data object RefreshData : PortfolioIntent()
    data object ClearError : PortfolioIntent()
    data object ToggleDarkMode : PortfolioIntent()
    data class SelectSection(val section: NavigationSection) : PortfolioIntent()
    data class ToggleNavigationCollapse(val isCollapsed: Boolean) : PortfolioIntent()
}

sealed interface UiEvent {
    data class OpenUrl(val url: String) : UiEvent
}