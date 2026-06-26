package com.ranjan.myportfolio.presentation.components.common

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun SocialMediaButton(
    icon: ImageVector,
    label: String,
    url: String,
    onClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = { onClick(url) },
        modifier = modifier.height(56.dp),
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            modifier = Modifier.size(20.dp)
        )
    }
}