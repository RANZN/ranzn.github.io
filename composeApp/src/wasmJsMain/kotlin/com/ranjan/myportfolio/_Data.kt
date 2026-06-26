package com.ranjan.myportfolio

import com.ranjan.myportfolio.data.models.*
import com.ranjan.myportfolio.presentation.icons.KotlinMultiplatform
import kotlinx.collections.immutable.persistentListOf
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.*

object UserData {
    val PROFILE = Res.drawable.compose_multiplatform
    const val NAME = "Prakash Ranjan"
    const val JOB_TITLE = "Senior Android Developer\nCompose Multiplatform Developer"
    const val ROLE = "SOFTWARE ENGINEER"
    const val EMAIL = "prakashranjan2803@gmail.com"
    const val CONTACT = "+91 7319886550"
    const val LINKEDIN_USERNAME = "prakash-ranzan"
    const val GITHUB_USERNAME = "RANZN"
    const val MEDIUM_USERNAME = "prakash_ranjan"
    const val GITHUB_LINK = "https://github.com/$GITHUB_USERNAME"
    const val MEDIUM_LINK = "https://medium.com/@$MEDIUM_USERNAME"
    const val LINKEDIN_LINK = "https://linkedin.com/in/$LINKEDIN_USERNAME"

    const val ABOUT_DESCRIPTION =
        "Passionate about creating intuitive and engaging user experiences. Specialize in transforming ideas into beautifully crafted products."

    val LANGUAGES = persistentListOf(
        FeaturedItem(imageResource = Res.drawable.kotlin, title = "Kotlin"),
        FeaturedItem(imageResource = Res.drawable.java, title = "Java")
    )

    val MOBILE = persistentListOf(
        FeaturedItem(imageResource = Res.drawable.android, title = "Android"),
        FeaturedItem(imageResource = Res.drawable.kotlinMultiplatformIcon, title = "Kotlin Multiplatform"),
        FeaturedItem(imageResource = Res.drawable.jetpackcompose, title = "Jetpack Compose"),
        FeaturedItem(imageResource = Res.drawable.composeMultiplatformIcon, title = "Compose Multiplatform")
    )

    val ARCHITECTURE = persistentListOf(
        FeaturedItem(imageResource = Res.drawable.kotlin, title = "MVVM"),
        FeaturedItem(imageResource = Res.drawable.kotlin, title = "MVI"),
        FeaturedItem(imageResource = Res.drawable.kotlin, title = "Clean Architecture"),
        FeaturedItem(imageResource = Res.drawable.kotlin, title = "Coroutines"),
        FeaturedItem(imageResource = Res.drawable.kotlin, title = "Flow")
    )

    val BACKEND = persistentListOf(
        FeaturedItem(imageResource = Res.drawable.ktor, title = "Ktor"),
        FeaturedItem(imageResource = Res.drawable.firebase, title = "Firebase"),
        FeaturedItem(imageResource = Res.drawable.auth0, title = "Auth0")
    )

    val DATABASES = persistentListOf(
        FeaturedItem(imageResource = Res.drawable.sqlite, title = "SQLite"),
        FeaturedItem(imageResource = Res.drawable.android, title = "SQLDelight"),
        FeaturedItem(imageResource = Res.drawable.android, title = "Room")
    )

    val DEPENDENCY_INJECTION = persistentListOf(
        FeaturedItem(imageResource = Res.drawable.kotlin, title = "Koin"),
        FeaturedItem(imageResource = Res.drawable.kotlin, title = "Hilt")
    )

    val VERSION_CONTROL = persistentListOf(
        FeaturedItem(imageResource = Res.drawable.git, title = "Git"),
        FeaturedItem(imageResource = Res.drawable.github, title = "GitHub"),
        FeaturedItem(imageResource = Res.drawable.bitbucket, title = "Bitbucket")
    )

    val DEVELOPMENT_TOOLS = persistentListOf(
        FeaturedItem(imageResource = Res.drawable.androidstudio, title = "Android Studio"),
        FeaturedItem(imageResource = Res.drawable.intellijidea, title = "IntelliJ IDEA"),
        FeaturedItem(imageResource = Res.drawable.postman, title = "Postman"),
        FeaturedItem(imageResource = Res.drawable.figma, title = "Figma")
    )

    val AI_TOOLS = persistentListOf(
        FeaturedItem(imageResource = Res.drawable.cursor, title = "Cursor", description = "AI Coding Assistant"),
        FeaturedItem(
            imageResource = Res.drawable.claudecode,
            title = "Claude Code",
            description = "AI Coding Assistant"
        ),
        FeaturedItem(imageResource = Res.drawable.claude, title = "Claude", description = "AI Assistant"),
        FeaturedItem(imageResource = Res.drawable.googlegemini, title = "Gemini", description = "AI Assistant"),
        FeaturedItem(imageResource = Res.drawable.ollama, title = "Ollama", description = "Local AI Runtime")
    )
}