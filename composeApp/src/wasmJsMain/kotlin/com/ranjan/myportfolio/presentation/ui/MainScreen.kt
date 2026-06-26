package com.ranjan.myportfolio.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.data.models.NavigationSection
import com.ranjan.myportfolio.domain.models.PortfolioState
import com.ranjan.myportfolio.presentation.components.sections.*
import com.ranjan.myportfolio.presentation.design.DesignSystem
import kotlinx.collections.immutable.PersistentList
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter

@Composable
fun MainContent(
    portfolioState: PortfolioState,
    navigationSections: PersistentList<NavigationSection>,
    selectedSection: () -> NavigationSection,
    onSectionSelected: (NavigationSection) -> Unit = {},
    onClick: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    isLargeScreen: Boolean
) {
    val scrollState = rememberLazyListState()
    var isAutoScrolling by remember { mutableStateOf(false) }
    LaunchedEffect(selectedSection()) {
        if (scrollState.isScrollInProgress) return@LaunchedEffect
        val index = navigationSections.indexOfFirst { it == selectedSection() }
        if (index >= 0) {
            isAutoScrolling = true
            scrollState.animateScrollToItem(index)
            isAutoScrolling = false
        }
    }

    LaunchedEffect(scrollState) {
        snapshotFlow { scrollState.firstVisibleItemIndex }
            .distinctUntilChanged()
            .collect { index ->
                if (!isAutoScrolling) navigationSections.getOrNull(index)?.let(onSectionSelected)
            }
    }

    LazyColumn(
        state = scrollState,
        modifier = modifier
            .fillMaxSize()
            .widthIn(max = DesignSystem.Layout.contentMaxWidth)
            .padding(horizontal = if (isLargeScreen) DesignSystem.Spacing.xxl else DesignSystem.Spacing.lg),
        contentPadding = PaddingValues(vertical = DesignSystem.Spacing.exl),
        verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.xxxl),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item(key = NavigationSection.ABOUT) {
            AboutSection(profile = portfolioState.profile)
        }

        item {
            Spacer(Modifier.height(200.dp).blur(50.dp))
        }

        item(NavigationSection.PROJECTS) {
            ProjectsSection(
                projects = portfolioState.projects,
                onClick = onClick,
                isLargeScreen = isLargeScreen
            )
        }

        item(NavigationSection.SKILLS) {
            SkillsSection(
                skills = portfolioState.skills,
                isLargeScreen = isLargeScreen
            )
        }

        item(NavigationSection.ARTICLES) {
            ArticlesSection(
                articles = portfolioState.articles,
                onClick = onClick,
            )
        }

        item(NavigationSection.EDUCATION) {
            EducationSection(
                education = portfolioState.education,
                isLargeScreen = isLargeScreen
            )
        }

        item(NavigationSection.CONTACT) {
            ContactSection(
                contactInfo = portfolioState.contactInfo,
                onClick = onClick,
                isLargeScreen = isLargeScreen
            )
        }
    }
}