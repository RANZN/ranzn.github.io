package com.ranjan.myportfolio.data.models

import com.ranjan.myportfolio.UserData

data class ContactInfo(
    val email: String = "",
    val linkedin: String = "",
    val github: String = "",
    val phone: String = "",
    val medium: String = UserData.MEDIUM_LINK,
    val twitter: String? = null
)