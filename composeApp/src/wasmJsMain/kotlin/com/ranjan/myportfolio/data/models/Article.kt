package com.ranjan.myportfolio.data.models

import kotlinx.serialization.Serializable

@Serializable
data class AllOriginsResponse(
    val contents: String
)

@Serializable
data class Article(
    val title: String = "",
    val link: String = "",
    val description: String = "",
    val pubDate: String = "",
    val categories: List<String> = emptyList()
)