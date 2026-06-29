package com.ranjan.myportfolio.presentation.components.sections

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.data.models.FeaturedItem
import com.ranjan.myportfolio.presentation.components.common.SectionTitleBody
import com.ranjan.myportfolio.presentation.design.DesignSystem
import org.jetbrains.compose.resources.painterResource

@Composable
fun ToolsSection(
    title: String,
    tools: List<FeaturedItem>,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.xl)
    ) {
        SectionTitleBody(title)

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.md),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.md),
        ) {
            tools.forEach { tool ->
                ToolChip(tool)
            }
        }
    }
}

@Composable
private fun ToolChip(item: FeaturedItem) {
    val title = remember(item.title) {
        val words = item.title.split(' ')

        when {
            words.size == 1 -> words.first()
            words.all { it.length > 2 } -> words.joinToString("\n")
            else -> words.joinToString(" ")
        }
    }

    Surface(
        shape = RoundedCornerShape(10),
        color = MaterialTheme.colorScheme.inverseSurface,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.4f))
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(item.imageResource),
                contentDescription = item.title,
                modifier = Modifier.size(54.dp)
            )
            Text(
                text = title,
                modifier = Modifier,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.background
            )
        }
    }
}