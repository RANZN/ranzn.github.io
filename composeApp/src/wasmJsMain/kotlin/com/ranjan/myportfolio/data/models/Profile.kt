package com.ranjan.myportfolio.data.models

import androidx.compose.runtime.Stable
import com.ranjan.myportfolio.UserData
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.profile_placeholder
import org.jetbrains.compose.resources.DrawableResource

@Stable
data class Profile(
    val name: String = UserData.NAME,
    val title: String = UserData.JOB_TITLE,
    val aboutDescription: List<String> = UserData.ABOUT_DESCRIPTION,
    val profileImageRes: DrawableResource = Res.drawable.profile_placeholder
)