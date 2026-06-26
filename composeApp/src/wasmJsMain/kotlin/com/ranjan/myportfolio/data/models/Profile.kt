package com.ranjan.myportfolio.data.models

import androidx.compose.runtime.Stable
import com.ranjan.myportfolio.UserData
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.profile_pic
import org.jetbrains.compose.resources.DrawableResource

@Stable
data class Profile(
    val name: String = UserData.NAME,
    val title: String = UserData.JOB_TITLE,
    val role: String = UserData.ROLE,
    val aboutDescription: String = UserData.ABOUT_DESCRIPTION,
    val profileImageRes: DrawableResource = Res.drawable.profile_pic
)