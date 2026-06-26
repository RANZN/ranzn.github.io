package com.ranjan.myportfolio.presentation.theme

import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color

// Light theme - GitHub inspired
private val LightPrimary = Color(0xFF0969DA) // GitHub blue
private val LightOnPrimary = Color(0xFFFFFFFF)
private val LightPrimaryContainer = Color(0xFFDDF4FF) // Light blue background
private val LightOnPrimaryContainer = Color(0xFF0969DA)
private val LightSecondary = Color(0xFF8250DF) // GitHub purple
private val LightOnSecondary = Color(0xFFFFFFFF)
private val LightSecondaryContainer = Color(0xFFF3E8FF)
private val LightOnSecondaryContainer = Color(0xFF8250DF)
private val LightTertiary = Color(0xFF1A7F37) // GitHub green
private val LightOnTertiary = Color(0xFFFFFFFF)
private val LightTertiaryContainer = Color(0xFFDDF4E5)
private val LightOnTertiaryContainer = Color(0xFF1A7F37)
private val LightError = Color(0xFFCF222E) // GitHub red
private val LightOnError = Color(0xFFFFFFFF)
private val LightErrorContainer = Color(0xFFFFEBE9)
private val LightOnErrorContainer = Color(0xFFCF222E)
private val LightBackground = Color(0xFFFFFFFF) // Pure white like GitHub
private val LightOnBackground = Color(0xFF24292F) // GitHub text color
private val LightSurface = Color(0xFFF6F8FA) // GitHub card background
private val LightOnSurface = Color(0xFF24292F) // GitHub text color
private val LightSurfaceVariant = Color(0xFFF6F8FA) // GitHub subtle background
private val LightOnSurfaceVariant = Color(0xFF57606A) // GitHub secondary text
private val LightOutline = Color(0xFFD0D7DE) // GitHub border color
private val LightInverseOnSurface = Color(0xFFFFFFFF)
private val LightInverseSurface = Color(0xFF24292F)
private val LightInversePrimary = Color(0xFF0969DA)

// Dark theme - GitHub dark mode inspired
private val DarkPrimary = Color(0xFF58A6FF) // GitHub blue for dark mode
private val DarkOnPrimary = Color(0xFF0D1117)
private val DarkPrimaryContainer = Color(0xFF1C2128) // Dark blue container
private val DarkOnPrimaryContainer = Color(0xFF58A6FF)
private val DarkSecondary = Color(0xFFBC8CFF) // GitHub purple for dark mode
private val DarkOnSecondary = Color(0xFF0D1117)
private val DarkSecondaryContainer = Color(0xFF2D1B3D)
private val DarkOnSecondaryContainer = Color(0xFFBC8CFF)
private val DarkTertiary = Color(0xFF3FB950) // GitHub green for dark mode
private val DarkOnTertiary = Color(0xFF0D1117)
private val DarkTertiaryContainer = Color(0xFF1C2B1F)
private val DarkOnTertiaryContainer = Color(0xFF3FB950)
private val DarkError = Color(0xFFF85149) // GitHub red for dark mode
private val DarkErrorContainer = Color(0xFF3D1F1F)
private val DarkOnError = Color(0xFF0D1117)
private val DarkOnErrorContainer = Color(0xFFF85149)
private val DarkBackground = Color(0xFF000000) // GitHub dark background
private val DarkOnBackground = Color(0xFFC9D1D9) // GitHub text color
private val DarkSurface = Color(0xFF161B22) // GitHub card background
private val DarkOnSurface = Color(0xFFC9D1D9) // GitHub text color
private val DarkSurfaceVariant = Color(0xFF161B22) // GitHub subtle background
private val DarkOnSurfaceVariant = Color(0xFF8B949E) // GitHub secondary text
private val DarkOutline = Color(0xFF30363D) // GitHub border color
private val DarkInverseOnSurface = Color(0xFF0D1117)
private val DarkInverseSurface = Color(0xFFC9D1D9)
private val DarkInversePrimary = Color(0xFF58A6FF)

val PortfolioLightColorScheme = lightColorScheme(
    primary = LightPrimary,
    onPrimary = LightOnPrimary,
    primaryContainer = LightPrimaryContainer,
    onPrimaryContainer = LightOnPrimaryContainer,
    secondary = LightSecondary,
    onSecondary = LightOnSecondary,
    secondaryContainer = LightSecondaryContainer,
    onSecondaryContainer = LightOnSecondaryContainer,
    tertiary = LightTertiary,
    onTertiary = LightOnTertiary,
    tertiaryContainer = LightTertiaryContainer,
    onTertiaryContainer = LightOnTertiaryContainer,
    error = LightError,
    errorContainer = LightErrorContainer,
    onError = LightOnError,
    onErrorContainer = LightOnErrorContainer,
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurfaceVariant,
    outline = LightOutline,
    inverseOnSurface = LightInverseOnSurface,
    inverseSurface = LightInverseSurface,
    inversePrimary = LightInversePrimary,
)

val PortfolioDarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkOnPrimary,
    primaryContainer = DarkPrimaryContainer,
    onPrimaryContainer = DarkOnPrimaryContainer,
    secondary = DarkSecondary,
    onSecondary = DarkOnSecondary,
    secondaryContainer = DarkSecondaryContainer,
    onSecondaryContainer = DarkOnSecondaryContainer,
    tertiary = DarkTertiary,
    onTertiary = DarkOnTertiary,
    tertiaryContainer = DarkTertiaryContainer,
    onTertiaryContainer = DarkOnTertiaryContainer,
    error = DarkError,
    errorContainer = DarkErrorContainer,
    onError = DarkOnError,
    onErrorContainer = DarkOnErrorContainer,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurfaceVariant,
    outline = DarkOutline,
    inverseOnSurface = DarkInverseOnSurface,
    inverseSurface = DarkInverseSurface,
    inversePrimary = DarkInversePrimary,
)