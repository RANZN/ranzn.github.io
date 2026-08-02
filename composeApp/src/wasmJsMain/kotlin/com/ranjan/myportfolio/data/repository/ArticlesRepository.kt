package com.ranjan.myportfolio.data.repository

import com.ranjan.myportfolio.data.models.RssResponse
import com.ranjan.myportfolio.domain.models.Article
import com.ranjan.myportfolio.domain.models.toArticle
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ArticlesRepository(
    private val httpClient: HttpClient
) {
    suspend fun fetchArticles(username: String): List<Article> {
        if (username.isBlank()) return emptyList()
        val response = httpClient.get("https://api.rss2json.com/v1/api.json") {
            url {
                parameters.append("rss_url", "https://medium.com/feed/@$username")
            }
        }

        val body = response.body<RssResponse>()
        if (body.status != "ok") return emptyList()

        return body.items.map { it.toArticle() }
    }
}