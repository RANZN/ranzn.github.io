package com.ranjan.myportfolio.domain.models

import androidx.compose.runtime.Stable
import com.ranjan.myportfolio.data.models.RssItem
import kotlinx.serialization.Serializable

@Serializable
@Stable
data class Article(
    val title: String = "",
    val link: String = "",
    val description: String = "",
    val pubDate: String = "",
    val categories: List<String> = emptyList()
)

fun RssItem.toArticle() : Article{
    return Article(
        title = this.title,
        link = this.link,
        description = (this.description.takeIf(String::isNotBlank) ?: this.content)
            .stripHtml()
            .let { text ->
                if (text.length > 50) "${text.take(50)}..." else text
            },
        pubDate = this.pubDate,
        categories = this.categories
    )
}

private fun String.stripHtml(): String =
    replace(Regex("<[^>]*>"), " ")
        .replace(Regex("\\s+"), " ")
        .trim()