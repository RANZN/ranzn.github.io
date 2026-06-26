package com.ranjan.myportfolio

import com.ranjan.myportfolio.data.models.*
import kotlinx.collections.immutable.persistentListOf
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.*

object UserData {
    val PROFILE = Res.drawable.profile_pic
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

    val PROJECTS = persistentListOf(
        Project(
            title = "MyPortfolio",
            description = "Personal portfolio website built with Kotlin Multiplatform and Compose for Web, showcasing modern cross-platform development",
            technologies = listOf("Kotlin Multiplatform", "Compose Multiplatform", "WASM", "Web"),
            link = "https://github.com/RANZN/MyPortfolio",
            imageUrl = null,
        ),
        Project(
            title = "SmartCents",
            description = "Personal finance management app with expense tracking and budget management using modern Android architecture",
            technologies = listOf("Kotlin", "Android", "Room", "MVVM", "Material Design", "Jetpack Compose"),
            link = "https://github.com/RANZN/SmartCents",
            imageUrl = null,
        ),
        Project(
            title = "Forum Mobile Android",
            description = "Mobile forum application with real-time messaging and community features built with modern Android stack",
            technologies = listOf("Kotlin", "Android", "Firebase", "Material Design", "Real-time", "Jetpack Compose"),
            link = "https://github.com/RANZN/forum-mobile-android",
            imageUrl = null,
        ),
        Project(
            title = "Evangelist Apps Projects",
            description = "Professional Android applications developed at Evangelist Apps using cutting-edge technologies",
            technologies = listOf("Kotlin", "Android", "Kotlin Multiplatform", "Jetpack Compose"),
            link = "https://github.com/RANZN",
            imageUrl = null,
        )
    )

    val EDUCATION = persistentListOf(
        Education(
            degree = "Bachelor of Technology - BTech",
            institution = "KIIT - Kalinga Institute of Industrial Technology",
            year = "Jan 2017 - Jan 2021",
            description = "Electrical and Electronics Engineering with focus on software development and mobile technologies",
            gpa = "8.02"
        ),
        Education(
            degree = "Professional Android Development",
            institution = "Masai School",
            year = "Apr 2021 - Jan 2022",
            description = "Advanced Android development with Kotlin Multiplatform and Jetpack Compose in production environment",
        )
    )
}