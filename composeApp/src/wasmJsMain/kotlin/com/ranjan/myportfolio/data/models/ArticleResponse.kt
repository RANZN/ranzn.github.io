package com.ranjan.myportfolio.data.models

import kotlinx.serialization.Serializable

@Serializable
data class RssResponse(
    val status: String = "",
    val items: List<RssItem> = emptyList()
)

@Serializable
data class RssItem(
    val title: String = "",
    val link: String = "",
    val description: String = "",
    val pubDate: String = "",
    val content: String = "",
    val categories: List<String> = emptyList()
)