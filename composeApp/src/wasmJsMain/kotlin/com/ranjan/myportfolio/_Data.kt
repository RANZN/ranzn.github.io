package com.ranjan.myportfolio

import com.ranjan.myportfolio.data.models.*
import com.ranjan.myportfolio.presentation.icons.KotlinMultiplatform
import compose.icons.SimpleIcons
import compose.icons.simpleicons.*
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.compose_multiplatform

object UserData {
    val PROFILE = Res.drawable.compose_multiplatform
    const val NAME = "Prakash Ranjan"
    const val JOB_TITLE = "Senior Android Developer\nCompose Multiplatform Developer"
    const val EMAIL = "prakashranjan2803@gmail.com"
    const val CONTACT = "+91 7319886550"
    const val LINKEDIN = "https://linkedin.com/in/prakash-ranzan"
    const val GITHUB = "https://github.com/RANZN"
    const val TWITTER = "https://twitter.com/prakashranjan"
    const val MEDIUM = "https://medium.com/@prakash_ranjan"

    val ABOUT_DESCRIPTION = listOf(
        "Highly motivated Senior Android Developer with expertise in developing, testing, and deploying Android applications. Currently working at Evangelist Apps, specializing in Kotlin Multiplatform and Jetpack Compose technologies.",
        "I possess strong analytical and problem-solving skills with a solid understanding of mobile app development. Skilled in Java, Kotlin, Android Studio, and SQLite, along with code versioning using GitHub and Bitbucket, following Agile Scrum methodology for product development."
    )

    val SKILLS = listOf(
        Skill("Kotlin", 0.9f, SimpleIcons.Kotlin),
        Skill("Kotlin Multiplatform", 0.7f, SimpleIcons.KotlinMultiplatform),
        Skill(
            "Compose Multiplatform",
            0.8f,
            SimpleIcons.KotlinMultiplatform
        ),
        Skill("Jetpack Compose", 0.85f, SimpleIcons.Kotlin),
        Skill("Android", 0.9f, SimpleIcons.Android),
        Skill("Android Studio", 0.85f, SimpleIcons.Androidstudio),
        Skill("Java", 0.8f, SimpleIcons.Java),
        Skill("SQLite", 0.75f, SimpleIcons.Sqlite),
        Skill("Git", 0.8f, SimpleIcons.Git),
        Skill("GitHub", 0.8f, SimpleIcons.Github),
        Skill("Bitbucket", 0.75f, SimpleIcons.Bitbucket),
        Skill("Firebase", 0.7f, SimpleIcons.Firebase),
        Skill("Ktor", 0.3f, SimpleIcons.Kotlin),
        Skill("Koin", 0.8f, SimpleIcons.Kotlin)
    )

}