package com.ranjan.myportfolio.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.myportfolio.UserData
import com.ranjan.myportfolio.data.models.NavigationSection
import com.ranjan.myportfolio.domain.models.PortfolioState
import com.ranjan.myportfolio.presentation.components.sections.*
import com.ranjan.myportfolio.presentation.design.DesignSystem
import kotlinx.collections.immutable.PersistentList
import kotlinx.coroutines.flow.distinctUntilChanged

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
        if (isLargeScreen.not()) item {
            ProfileUi(
                profile = portfolioState.profile,
                mediaPlatforms = portfolioState.mediaPlatforms,
                modifier = Modifier,
                onPlatformClick = onClick,
            )
        }
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            SpanStyle(
                                color = Color.White,
                                fontWeight = FontWeight.Black,
                                fontSize = 94.sp,
                            )
                        ) {
                            append("PREMIUM\n")
                        }

                        withStyle(
                            SpanStyle(
                                color = Color.Gray,
                                fontWeight = FontWeight.Black,
                                fontSize = 90.sp
                            )
                        ) {
                            append("TOOLS")
                        }
                    },
                    style = MaterialTheme.typography.displayLarge,
                    fontSize = 94.sp,
                    lineHeight = 90.sp
                )
            }
        }

        item {
            ToolsSection(
                title = "AI Tools",
                tools = UserData.AI_TOOLS,
                isLargeScreen = isLargeScreen
            )
        }

        item {
            ToolsSection(
                title = "Development Tools",
                tools = UserData.DEVELOPMENT_TOOLS,
                isLargeScreen = isLargeScreen
            )
        }

        item {
            ToolsSection(
                title = "Version Control",
                tools = UserData.VERSION_CONTROL,
                isLargeScreen = isLargeScreen
            )
        }

        item {
            ToolsSection(
                title = "Databases",
                tools = UserData.DATABASES,
                isLargeScreen = isLargeScreen
            )
        }

        item {
            ToolsSection(
                title = "Backend",
                tools = UserData.BACKEND,
                isLargeScreen = isLargeScreen
            )
        }

        item {
            ToolsSection(
                title = "Mobile",
                tools = UserData.MOBILE,
                isLargeScreen = isLargeScreen
            )
        }

        item {
            ToolsSection(
                title = "Languages",
                tools = UserData.LANGUAGES,
                isLargeScreen = isLargeScreen
            )
        }

        item(NavigationSection.ARTICLES) {
            ArticlesSection(
                articlesState = portfolioState.articlesState,
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