package com.ranjan.myportfolio.domain.repository

import com.ranjan.myportfolio.data.models.*
import kotlinx.collections.immutable.PersistentList

interface PortfolioRepository {
    fun getProfile(): Profile
    suspend fun getSkills(): List<FeaturedItem>
    suspend fun getProjects(): PersistentList<Project>
    suspend fun getArticles(): Result<List<Article>>
    fun getEducation(): PersistentList<Education>
    fun getContactInfo(): ContactInfo
    fun getNavigationSections(): List<NavigationSection>
    fun getExperience(): PersistentList<Experience>
}