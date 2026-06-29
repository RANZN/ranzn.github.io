package com.ranjan.myportfolio.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun MainContent(
    portfolioState: PortfolioState,
    onClick: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    isLargeScreen: Boolean,
    scrollState: LazyListState = rememberLazyListState()
) {
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
            Spacer(Modifier.fillMaxWidth().height(200.dp).blur(50.dp))
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
            )
        }

        item {
            ToolsSection(
                title = "Development Tools",
                tools = UserData.DEVELOPMENT_TOOLS,
            )
        }

        item {
            ToolsSection(
                title = "Version Control",
                tools = UserData.VERSION_CONTROL,
            )
        }

        item {
            ToolsSection(
                title = "Databases",
                tools = UserData.DATABASES,
            )
        }

        item {
            ToolsSection(
                title = "Backend",
                tools = UserData.BACKEND,
            )
        }

        item {
            ToolsSection(
                title = "Mobile",
                tools = UserData.MOBILE,
            )
        }

        item {
            ToolsSection(
                title = "Languages",
                tools = UserData.LANGUAGES,
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