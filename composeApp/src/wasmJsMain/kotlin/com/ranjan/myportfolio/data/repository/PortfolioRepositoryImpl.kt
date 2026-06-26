package com.ranjan.myportfolio.data.repository

import com.ranjan.myportfolio.UserData
import com.ranjan.myportfolio.data.models.*
import com.ranjan.myportfolio.data.service.JsonDataService
import com.ranjan.myportfolio.data.service.PortfolioJsonData
import com.ranjan.myportfolio.domain.repository.PortfolioRepository
import kotlinx.collections.immutable.PersistentList
import org.jetbrains.skia.Data

class PortfolioRepositoryImpl(
    private val jsonDataService: JsonDataService,
    private val articlesRepository: ArticlesRepository
) : PortfolioRepository {

    // Cache the loaded JSON data
    private var cachedJsonData: PortfolioJsonData? = null

    override suspend fun getProfile(): Profile {
        return Profile(
            name = UserData.NAME,
            title = UserData.JOB_TITLE,
            profileImageRes = UserData.PROFILE,
            aboutDescription = UserData.ABOUT_DESCRIPTION
        )
    }

    override suspend fun getSkills(): List<FeaturedItem> = listOf(
        UserData.LANGUAGES,
        UserData.MOBILE,
        UserData.ARCHITECTURE,
        UserData.BACKEND,
        UserData.DATABASES,
        UserData.DEPENDENCY_INJECTION,
        UserData.VERSION_CONTROL,
        UserData.DEVELOPMENT_TOOLS,
        UserData.AI_TOOLS,
    ).flatten()

    override suspend fun getProjects(): List<Project> {
        val data = loadJsonData()
        return data?.projects ?: emptyList()
    }

    override suspend fun getArticles(): List<Article> = runCatching {
        articlesRepository.fetchArticles(UserData.MEDIUM_USERNAME)
    }.onFailure {
        print("Error fetching articles: ${it.message}")
    }.getOrElse { emptyList() }

    override suspend fun getEducation(): List<Education> {
        val data = loadJsonData()
        return data?.education ?: emptyList()
    }

    /**
     * Loads JSON data once and caches it for subsequent calls.
     * Loads from local resources (bundled JSON file).
     * The JSON file is loaded only once per app session.
     */
    private suspend fun loadJsonData(): PortfolioJsonData? {
        if (cachedJsonData == null) {
            cachedJsonData = jsonDataService.loadPortfolioData()
        }
        return cachedJsonData
    }

    override suspend fun getContactInfo(): ContactInfo {
        return ContactInfo(
            email = UserData.EMAIL,
            linkedin = UserData.LINKEDIN_LINK,
            github = UserData.GITHUB_LINK,
            phone = UserData.CONTACT,
            medium = UserData.MEDIUM_LINK
        )
    }

    override suspend fun getNavigationSections(): List<NavigationSection> {
        return NavigationSection.entries
    }
}