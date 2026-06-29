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
            degree = "Bachelor of Technology - BTech (EEE)",
            institution = "KIIT - Kalinga Institute of Industrial Technology",
            year = "Jan 2017 - Jan 2021",
            description = "Electrical and Electronics Engineering with focus on software development and mobile technologies",
            gpa = "8.02"
        ),
        Education(
            degree = "Post Graduate Diploma in Computer Applications",
            institution = "IGNOU",
            year = "Jun 2025 - Jul 2026",
            description = "Strengthening computer science fundamentals through coursework in programming, data structures, databases, operating systems, networking, and software engineering to complement professional Android and Kotlin Multiplatform development experience."
        )
    )

    val EXPERIENCE = persistentListOf(
        Experience(
            company = "Evangelist Apps",
            role = "Senior Android Developer",
            employmentType = "Full-time",
            location = "Fleet, London, UK",
            startDate = "Sept 2024",
            endDate = "Present",
            isCurrent = true,
            description = "Leading Android application development using modern Android architecture while mentoring developers and collaborating with cross-functional teams.",
            technologies = listOf(
                "Kotlin",
                "Jetpack Compose",
                "Coroutines",
                "Flow",
                "Hilt",
                "Room",
                "Retrofit",
                "Firebase"
            ),
            highlights = listOf(
                "Migrated legacy XML screens to Jetpack Compose.",
                "Implemented offline-first architecture.",
                "Reduced app startup time by 35%.",
                "Improved crash-free users to 99.8%.",
                "Introduced scalable MVI architecture.",
                "Introduced Widgets and App shortcuts for faster app access."
            )
        ),
        Experience(
            company = "Perennial Systems",
            role = "Android Developer",
            employmentType = "Full-time",
            location = "Pune, India",
            startDate = "Feb 2022",
            endDate = "Aug 2024",
            isCurrent = false,
            description = "Developed and maintained Android applications with a focus on performance, clean architecture, and user experience.",
            technologies = listOf(
                "Java",
                "Kotlin",
                "MVVM",
                "Navigation",
                "Paging 3",
                "WorkManager",
                "ExoPlayer",
            ),
            highlights = listOf(
                "Developed Fintech SDK",
                "Integrated REST APIs and push notifications.",
                "Fintech Application security",
            )
        ),
        Experience(
            company = "Masai School",
            role = "Android Developer",
            employmentType = "Internship",
            location = "Bangalore, India",
            startDate = "Apr 2021",
            endDate = "Jan 2022",
            isCurrent = false,
            description = "",
            technologies = listOf(
                "Java",
                "Kotlin",
                "MVVM",
                "Retrofit",
                "ViewModel",
            ),
            highlights = listOf()
        ),

    )
}