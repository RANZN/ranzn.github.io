package com.ranjan.myportfolio.data.models

import androidx.compose.runtime.Immutable


@Immutable
data class Experience(
    val company: String,
    val role: String,
    val employmentType: String,
    val location: String,
    val startDate: String,
    val endDate: String,
    val isCurrent: Boolean,
    val description: String,
    val technologies: List<String>,
    val highlights: List<String>,
    val companyLogo: String? = null,
    val companyWebsite: String? = null
)