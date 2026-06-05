package com.ranjan.myportfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.presentation.components.AnimatedBackground
import com.ranjan.myportfolio.presentation.components.ErrorScreen
import com.ranjan.myportfolio.presentation.components.LoadingScreen
import com.ranjan.myportfolio.presentation.components.navigation.NavigationSidebar
import com.ranjan.myportfolio.presentation.components.navigation.TopNavigationBar
import com.ranjan.myportfolio.presentation.theme.PortfolioDarkColorScheme
import com.ranjan.myportfolio.presentation.theme.PortfolioLightColorScheme
import com.ranjan.myportfolio.presentation.ui.MainContent
import com.ranjan.myportfolio.presentation.ui.PortfolioIntent
import com.ranjan.myportfolio.presentation.ui.PortfolioViewModel
import com.ranjan.myportfolio.presentation.ui.UiEvent
import kotlinx.browser.document
import kotlinx.browser.window
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App() {
    val viewModel: PortfolioViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsState()

    val portfolioState = uiState.portfolioState

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is UiEvent.OpenUrl -> {
                    window.open(event.url, "_blank")
                }
            }
        }
    }

    LaunchedEffect(portfolioState.profile.name, uiState.selectedSection) {
        document.title = "${portfolioState.profile.name} | Portfolio"
    }

    LaunchedEffect(uiState.selectedSection) {
        if (window.location.hash != "#${uiState.selectedSection.title}") {
            window.history.replaceState(null, "", "#${uiState.selectedSection.title}")
        }
    }

    MaterialTheme(
        colorScheme = if (uiState.isDarkMode) PortfolioDarkColorScheme else PortfolioLightColorScheme
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            AnimatedBackground(
                modifier = Modifier.fillMaxSize()
            )

            val isLargeScreen = maxWidth > 1200.dp
            val isMediumScreen = maxWidth > 800.dp

            when {
                uiState.isLoading -> {
                    LoadingScreen()
                }

                uiState.error != null -> {
                    ErrorScreen(
                        error = uiState.error!!,
                        onRetry = { viewModel.handleIntent(PortfolioIntent.RefreshData) },
                        onDismiss = { viewModel.handleIntent(PortfolioIntent.ClearError) }
                    )
                }

                else -> {
                    if (isLargeScreen) {
                        Row(modifier = Modifier.fillMaxSize()) {
                            NavigationSidebar(
                                profile = portfolioState.profile,
                                navigationSections = uiState.navigationSections,
                                selectedSection = { uiState.selectedSection },
                                onSectionSelected = { viewModel.handleIntent(PortfolioIntent.SelectSection(it)) },
                                isCollapsed = uiState.isNavigationCollapsed,
                                onToggleCollapse = {
                                    viewModel.handleIntent(PortfolioIntent.ToggleNavigationCollapse(!uiState.isNavigationCollapsed))
                                },
                                isDarkMode = uiState.isDarkMode,
                                onToggleDarkMode = { viewModel.handleIntent(PortfolioIntent.ToggleDarkMode) },
                                modifier = Modifier.width(if (uiState.isNavigationCollapsed) 80.dp else 280.dp)
                            )

                            MainContent(
                                portfolioState = portfolioState,
                                navigationSections = uiState.navigationSections,
                                selectedSection = { uiState.selectedSection },
                                onSectionSelected = { viewModel.handleIntent(PortfolioIntent.SelectSection(it)) },
                                onClick = { viewModel.onClick(it) },
                                modifier = Modifier.weight(1f),
                                isLargeScreen = isLargeScreen
                            )
                        }
                    } else {
                        Column(modifier = Modifier.fillMaxSize()) {
                            TopNavigationBar(
                                navigationSections = uiState.navigationSections,
                                selectedSection = { uiState.selectedSection },
                                onSectionSelected = { viewModel.handleIntent(PortfolioIntent.SelectSection(it)) },
                                isCompact = !isMediumScreen,
                                isDarkMode = uiState.isDarkMode,
                                onToggleDarkMode = { viewModel.handleIntent(PortfolioIntent.ToggleDarkMode) }
                            )

                            MainContent(
                                portfolioState = portfolioState,
                                navigationSections = uiState.navigationSections,
                                selectedSection = { uiState.selectedSection },
                                onSectionSelected = { viewModel.handleIntent(PortfolioIntent.SelectSection(it)) },
                                onClick = { viewModel.onClick(it) },
                                modifier = Modifier.weight(1f),
                                isLargeScreen = isLargeScreen
                            )
                        }
                    }
                }
            }
        }
    }
}