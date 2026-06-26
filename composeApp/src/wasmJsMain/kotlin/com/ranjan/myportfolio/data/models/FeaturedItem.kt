package com.ranjan.myportfolio.data.models

import org.jetbrains.compose.resources.DrawableResource

data class FeaturedItem(
    val imageResource: DrawableResource,
    val title: String,
    val description: String? = null
)