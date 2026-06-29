package com.ranjan.myportfolio.presentation.ui

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector
import com.ranjan.myportfolio.domain.models.PortfolioState


@Stable
data class PortfolioUiState(
    val portfolioState: PortfolioState = PortfolioState(),
    val isDarkMode: Boolean = true,
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
}

sealed interface UiEvent {
    data class OpenUrl(val url: String) : UiEvent
}