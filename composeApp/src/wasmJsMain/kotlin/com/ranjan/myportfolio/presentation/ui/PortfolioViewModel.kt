package com.ranjan.myportfolio.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ranjan.myportfolio.data.models.NavigationSection
import com.ranjan.myportfolio.domain.repository.PortfolioRepository
import com.ranjan.myportfolio.navigation.NavigationManager
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * ViewModel following MVI (Model-View-Intent) architecture
 * Handles all user intents and updates the single source of truth state
 * Separates domain state (data) from UI state (navigation, theme, etc.)
 */
class PortfolioViewModel(
    private val repository: PortfolioRepository,
    private val navigationManager: NavigationManager
) : ViewModel() {

    private val _uiState = MutableStateFlow(PortfolioUiState())
    val uiState: StateFlow<PortfolioUiState> = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<UiEvent>()
    val events: SharedFlow<UiEvent> = _events.asSharedFlow()

    init {
        initializeNavigation()
        handleIntent(PortfolioIntent.LoadPortfolioData)
    }

    override fun onCleared() {
        super.onCleared()
        navigationManager.removeNavigationListener()
    }

    fun handleIntent(intent: PortfolioIntent) {
        when (intent) {
            is PortfolioIntent.LoadPortfolioData -> loadPortfolioData()
            is PortfolioIntent.RefreshData -> refreshData()
            is PortfolioIntent.ClearError -> clearError()
            is PortfolioIntent.ToggleDarkMode -> toggleDarkMode()
            is PortfolioIntent.SelectSection -> selectSection(intent.section)
            is PortfolioIntent.ToggleNavigationCollapse -> toggleNavigationCollapse(intent.isCollapsed)
        }
    }

    private fun initializeNavigation() {
        val initialSection = navigationManager.getCurrentSection()
        _uiState.update { it.copy(selectedSection = initialSection) }

        navigationManager.setupNavigationListener { section ->
            _uiState.update { it.copy(selectedSection = section) }
        }
    }

    private fun loadPortfolioData() {
        _uiState.update { it.copy(isLoading = true, error = null) }

        viewModelScope.launch {
            try {
                val profileDeferred = async { repository.getProfile() }
                val skillsDeferred = async { repository.getSkills() }
                val projectsDeferred = async { repository.getProjects() }
                val articlesDeferred = async { repository.getArticles() }
                val educationDeferred = async { repository.getEducation() }
                val contactInfoDeferred = async { repository.getContactInfo() }

                val profile = profileDeferred.await()
                val skills = skillsDeferred.await()
                val projects = projectsDeferred.await()
                val articles = articlesDeferred.await()
                val education = educationDeferred.await()
                val contactInfo = contactInfoDeferred.await()

                _uiState.update {
                    it.copy(
                        portfolioState = it.portfolioState.copy(
                            profile = profile ?: it.portfolioState.profile,
                            skills = skills,
                            projects = projects,
                            articles = articles,
                            education = education,
                            contactInfo = contactInfo
                        ),
                        isLoading = false,
                        error = null
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = "Failed to load portfolio data: ${e.message}"
                    )
                }
            }
        }
    }

    private fun selectSection(section: NavigationSection) {
        _uiState.update { currentState ->
            if (currentState.selectedSection != section) {
                navigationManager.updateUrl(section)
                currentState.copy(selectedSection = section)
            } else {
                currentState
            }
        }
    }

    private fun toggleDarkMode() {
        _uiState.update { it.copy(isDarkMode = !it.isDarkMode) }
    }

    private fun toggleNavigationCollapse(isCollapsed: Boolean) {
        _uiState.update { it.copy(isNavigationCollapsed = isCollapsed) }
    }

    private fun refreshData() {
        loadPortfolioData()
    }

    private fun clearError() {
        _uiState.update { it.copy(error = null) }
    }

    fun onClick(url: String) {
        if (url.isNotBlank()) {
            viewModelScope.launch {
                _events.emit(UiEvent.OpenUrl(url))
            }
        }
    }
}