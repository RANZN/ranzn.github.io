package com.ranjan.myportfolio.domain.models

import androidx.compose.runtime.Stable
import com.ranjan.myportfolio.data.models.*

@Stable
data class PortfolioState(
    val profile: Profile = Profile(),
    val skills: List<Skill> = emptyList(),
    val projects: List<Project> = emptyList(),
    val articles: List<Article> = emptyList(),
    val education: List<Education> = emptyList(),
    val contactInfo: ContactInfo = ContactInfo()
)