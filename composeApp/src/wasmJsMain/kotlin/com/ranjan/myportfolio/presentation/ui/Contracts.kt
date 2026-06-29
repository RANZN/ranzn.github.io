package com.ranjan.myportfolio.presentation.ui

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector
import com.ranjan.myportfolio.data.models.*
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Stable
data class PortfolioUiState(
    val portfolioState: PortfolioState = PortfolioState(),
    val isDarkMode: Boolean = true,
    val isLoading: Boolean = false,
    val error: String? = null
)

@Stable
data class PortfolioState(
    val profile: Profile = Profile(),
    val mediaPlatforms: PersistentList<SocialMediaPlatform> = persistentListOf(),
    val skills: PersistentList<FeaturedItem> = persistentListOf(),
    val projects: PersistentList<Project> = persistentListOf(),
    val articlesState: ArticlesState = ArticlesState.Loading,
    val education: PersistentList<Education> = persistentListOf(),
    val contactInfo: ContactInfo = ContactInfo(),
    val experience: PersistentList<Experience> = persistentListOf()
)

@Stable

sealed interface ArticlesState {
    data object Loading : ArticlesState
    data class Success(val articles: PersistentList<Article>, val mediumUrl: String) : ArticlesState
    data class Error(val mediumUrl: String) : ArticlesState
}

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