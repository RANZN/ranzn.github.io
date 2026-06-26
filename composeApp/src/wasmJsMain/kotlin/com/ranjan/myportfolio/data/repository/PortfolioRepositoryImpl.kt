package com.ranjan.myportfolio.data.repository

import com.ranjan.myportfolio.UserData
import com.ranjan.myportfolio.data.models.*
import com.ranjan.myportfolio.domain.repository.PortfolioRepository

class PortfolioRepositoryImpl(
    private val articlesRepository: ArticlesRepository
) : PortfolioRepository {

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
        return UserData.PROJECTS
    }

    override suspend fun getArticles(): Result<List<Article>> = runCatching {
        Result.success(articlesRepository.fetchArticles(UserData.MEDIUM_USERNAME))
    }.onFailure {
        print("Error fetching articles: ${it.message}")
    }.getOrElse { Result.failure(Exception("Unknown error")) }

    override suspend fun getEducation(): List<Education> {
        return UserData.EDUCATION
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