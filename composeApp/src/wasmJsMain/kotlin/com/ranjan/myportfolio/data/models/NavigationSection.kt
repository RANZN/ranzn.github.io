package com.ranjan.myportfolio.data.models

import myportfolio.composeapp.generated.resources.*
import org.jetbrains.compose.resources.DrawableResource

enum class NavigationSection(
    val title: String,
    val icon: DrawableResource
) {
    ABOUT("About", Res.drawable.user),
    SKILLS("Skills", Res.drawable.star),
    EXPERIENCE("Experience", Res.drawable.briefcase),
    PROJECTS("Projects", Res.drawable.briefcase),
    ARTICLES("Articles", Res.drawable.file_text),
    EDUCATION("Education", Res.drawable.book_open),
    CONTACT("Contact", Res.drawable.mail);

    companion object {
        fun fromString(name: String): NavigationSection? {
            return entries.find { it.title.equals(name, ignoreCase = true) }
        }

        fun fromUrlHash(hash: String): NavigationSection {
            return fromString(hash) ?: ABOUT
        }
    }
}