package com.ranjan.myportfolio.domain.models

import androidx.compose.runtime.Stable
import com.ranjan.myportfolio.data.models.*
import com.ranjan.myportfolio.presentation.ui.SocialMediaPlatform
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Stable
data class PortfolioState(
    val profile: Profile = Profile(),
    val mediaPlatforms: PersistentList<SocialMediaPlatform> = persistentListOf(),
    val skills: List<FeaturedItem> = emptyList(),
    val projects: List<Project> = emptyList(),
    val articlesState: ArticlesState = ArticlesState.Loading,
    val education: List<Education> = emptyList(),
    val contactInfo: ContactInfo = ContactInfo()
)

@Stable

sealed interface ArticlesState {
    data object Loading : ArticlesState
    data class Success(val articles: PersistentList<Article>, val mediumUrl: String) : ArticlesState
    data class Error(val mediumUrl: String) : ArticlesState
}