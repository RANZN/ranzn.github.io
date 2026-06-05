package com.ranjan.myportfolio.data.service

import com.ranjan.myportfolio.data.models.Article
import com.ranjan.myportfolio.data.models.Education
import com.ranjan.myportfolio.data.models.Project
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.readResourceBytes
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.InternalResourceApi

/**
 * Service to load portfolio data from bundled JSON resources.
 * Data is loaded once and cached in memory.
 */
interface JsonDataService {
    suspend fun loadPortfolioData(): PortfolioJsonData
}

@Serializable
data class PortfolioJsonData(
    val articles: List<Article> = emptyList(),
    val projects: List<Project> = emptyList(),
    val education: List<Education> = emptyList()
)

class JsonDataServiceImpl : JsonDataService {

    private var cachedData: PortfolioJsonData? = null

    val json = Json{
        ignoreUnknownKeys = true
    }

    @OptIn(ExperimentalResourceApi::class, InternalResourceApi::class)
    override suspend fun loadPortfolioData(): PortfolioJsonData {
        cachedData?.let { return it }

        val jsonText = readResourceBytes("portfolio-data.json").decodeToString()

        val parsedData = json.decodeFromString<PortfolioJsonData>(jsonText)

        cachedData = parsedData
        return parsedData
    }
}