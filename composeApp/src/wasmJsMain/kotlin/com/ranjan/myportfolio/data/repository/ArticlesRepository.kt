package com.ranjan.myportfolio.data.repository

import com.ranjan.myportfolio.data.models.AllOriginsResponse
import com.ranjan.myportfolio.data.models.Article
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import org.w3c.dom.Element
import org.w3c.dom.parsing.DOMParser

class ArticlesRepository(
    private val httpClient: HttpClient
) {
    suspend fun fetchArticles(username: String): List<Article> {
        if (username.isBlank()) return emptyList()
        val response = httpClient.get("https://api.allorigins.win/get") {
            url {
                parameters.append(
                    "url",
                    "https://medium.com/feed/@$username"
                )
            }
        }

        val result = response.body<AllOriginsResponse>()

        val document = DOMParser().parseFromString(
            result.contents,
            "application/xml".toJsString()
        )
        val items = document.getElementsByTagName("item")

        return buildList {
            for (i in 0 until items.length) {
                val item = items.item(i) ?: continue

                val tags = buildList {
                    val categories = item.getElementsByTagName("category")

                    for (j in 0 until categories.length) {
                        categories.item(j)
                            ?.textContent
                            ?.takeIf { it.isNotBlank() }
                            ?.let(::add)
                    }
                }

                add(
                    Article(
                        title = item.textOf("title"),
                        link = item.textOf("link"),
                        description = (item.textOf("description").takeIf { it.isNotBlank() }
                            ?: (item.textOf("content:encoded").take(50) + "...")).stripHtml(),
                        pubDate = item.textOf("pubDate"),
                        categories = tags
                    )
                )
            }
        }
    }
}

private fun Element.textOf(tag: String): String =
    getElementsByTagName(tag)
        .item(0)
        ?.textContent
        .orEmpty()

private fun String.stripHtml(): String =
    replace(Regex("<[^>]*>"), " ")
        .replace(Regex("\\s+"), " ")
        .trim()