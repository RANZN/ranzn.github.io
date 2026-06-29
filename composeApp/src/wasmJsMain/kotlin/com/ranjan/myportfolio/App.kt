package com.ranjan.myportfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.presentation.components.AnimatedBackground
import com.ranjan.myportfolio.presentation.components.ErrorScreen
import com.ranjan.myportfolio.presentation.components.LoadingScreen
import com.ranjan.myportfolio.presentation.design.DesignSystem
import com.ranjan.myportfolio.presentation.theme.PortfolioDarkColorScheme
import com.ranjan.myportfolio.presentation.theme.PortfolioLightColorScheme
import com.ranjan.myportfolio.presentation.ui.*
import com.ranjan.myportfolio.presentation.util.forwardScrollTo
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
                is UiEvent.OpenUrl -> window.open(event.url, "_blank")
            }
        }
    }

    LaunchedEffect(portfolioState.profile.name) {
        document.title = "${portfolioState.profile.name} | Portfolio"
    }

    MaterialTheme(
        colorScheme = if (uiState.isDarkMode) PortfolioDarkColorScheme else PortfolioLightColorScheme
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            AnimatedBackground(modifier = Modifier.fillMaxSize())

            val isLargeScreen = maxWidth > 1200.dp

            when {
                uiState.isLoading -> LoadingScreen()
                uiState.error != null -> ErrorScreen(
                    error = uiState.error!!,
                    onRetry = { viewModel.handleIntent(PortfolioIntent.RefreshData) },
                    onDismiss = { viewModel.handleIntent(PortfolioIntent.ClearError) }
                )

                else -> {
                    if (isLargeScreen) {
                        val sharedScrollState = rememberLazyListState()

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .forwardScrollTo(sharedScrollState),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                modifier = Modifier
                                    .widthIn(max = DesignSystem.Layout.contentMaxWidth)
                                    .fillMaxHeight(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                ProfileUi(
                                    profile = portfolioState.profile,
                                    mediaPlatforms = portfolioState.mediaPlatforms,
                                    modifier = Modifier.weight(0.4f).fillMaxHeight(0.7f),
                                    onPlatformClick = { viewModel.launchUrl(it) },
                                )
                                MainContent(
                                    portfolioState = portfolioState,
                                    onClick = { viewModel.launchUrl(it) },
                                    modifier = Modifier.weight(1f),
                                    isLargeScreen = isLargeScreen,
                                    scrollState = sharedScrollState,
                                )
                            }
                        }
                    } else {
                        MainContent(
                            portfolioState = portfolioState,
                            onClick = { viewModel.launchUrl(it) },
                            modifier = Modifier.fillMaxSize(),
                            isLargeScreen = isLargeScreen
                        )
                    }
                }
            }
        }
    }
}