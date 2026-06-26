package com.ranjan.myportfolio.presentation.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import kotlin.math.sin

@Composable
fun AnimatedBackground(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "background_animation")
    
    val primaryColor = Color(0xFF00E5FF)
    val secondaryColor = Color(0xFF7C4DFF)
    val tertiaryColor = Color(0xFFFF2D95)
    
    val offset1 by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 3000f,
        animationSpec = infiniteRepeatable(
            animation = tween(20000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "offset1"
    )
    
    val offset2 by infiniteTransition.animateFloat(
        initialValue = -1000f,
        targetValue = 3000f,
        animationSpec = infiniteRepeatable(
            animation = tween(25000, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "offset2"
    )
    
    val offset3 by infiniteTransition.animateFloat(
        initialValue = -2000f,
        targetValue = 3500f,
        animationSpec = infiniteRepeatable(
            animation = tween(30000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "offset3"
    )
    
    val density = LocalDensity.current
    
    Canvas(modifier = modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height
        
        // Draw curved lines
        drawCurvedLine(
            offset = offset1,
            color = primaryColor,
            width = width,
            height = height,
            amplitude = 150f,
            frequency = 0.003f,
            density = density
        )
        
        drawCurvedLine(
            offset = offset2,
            color = secondaryColor,
            width = width,
            height = height,
            amplitude = 200f,
            frequency = 0.0025f,
            density = density
        )
        
        drawCurvedLine(
            offset = offset3,
            color = tertiaryColor,
            width = width,
            height = height,
            amplitude = 180f,
            frequency = 0.0035f,
            density = density
        )
    }
}

private fun DrawScope.drawCurvedLine(
    offset: Float,
    color: Color,
    width: Float,
    height: Float,
    amplitude: Float,
    frequency: Float,
    density: Density
) {
    val path = Path()
    val startY = height * 0.3f + (offset % (height * 2)) - height
    
    path.moveTo(0f, startY)
    
    val points = 200
    for (i in 0..points) {
        val x = (i / points.toFloat()) * width
        val y = startY + amplitude * sin((x + offset) * frequency) + 
                (i / points.toFloat()) * (height * 0.4f)
        
        if (i == 0) {
            path.moveTo(x, y)
        } else {
            path.lineTo(x, y)
        }
    }
    
    drawPath(
        path = path,
        color = color,
        style = Stroke(width = with(density) { 2.dp.toPx() }, cap = StrokeCap.Round)
    )
    
    // Draw additional parallel lines for depth
    val path2 = Path()
    val startY2 = startY + 80f
    path2.moveTo(0f, startY2)
    
    for (i in 0..points) {
        val x = (i / points.toFloat()) * width
        val y = startY2 + amplitude * 0.7f * sin((x + offset + 50f) * frequency) + 
                (i / points.toFloat()) * (height * 0.4f)
        
        if (i == 0) {
            path2.moveTo(x, y)
        } else {
            path2.lineTo(x, y)
        }
    }
    
    drawPath(
        path = path2,
        color = color.copy(alpha = color.alpha * 0.6f),
        style = Stroke(width = with(density) { 1.5.dp.toPx() }, cap = StrokeCap.Round)
    )
}

