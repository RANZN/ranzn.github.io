package com.ranjan.myportfolio.presentation.design

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

/**
 * Centralized Design System for consistent UI across the portfolio
 * This ensures all components follow the same design language
 */

object DesignSystem {
    // Spacing System (8dp grid)
    object Spacing {
        val xs = 4.dp
        val sm = 8.dp
        val md = 16.dp
        val lg = 24.dp
        val xl = 32.dp
        val xxl = 48.dp
        val xxxl = 64.dp
        val exl = 100.dp
    }

    // Border Radius
    object Radius {
        val sm = 8.dp
        val md = 12.dp
        val lg = 16.dp
        val xl = 24.dp
        val full = 50.dp
    }

    // Elevation System
    object Elevation {
        val none = 0.dp
        val sm = 2.dp
        val md = 4.dp
        val lg = 8.dp
        val xl = 12.dp
    }

    // Card Styles
    object Cards {
        val defaultElevationDp = Elevation.md
        val hoverElevationDp = Elevation.lg
        val shape = RoundedCornerShape(Radius.lg)
        val padding = Spacing.lg
    }

    // Animation Durations
    object Animation {
        val fast = 200
        val normal = 300
        val slow = 500
    }

    // Content Max Width
    object Layout {
        val contentMaxWidth = 1200.dp
        val cardMaxWidth = 600.dp
    }
}

