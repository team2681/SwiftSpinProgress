package io.team2681.swiftspinprogress.compose.base

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import io.team2681.swiftspinprogress.compose.base.SwiftSpinProgressDefaults.Size

@Composable
fun SwiftSpinProgressIndicator(
    modifier: Modifier = Modifier,
    @androidx.annotation.IntRange(from = 4, to = 12) staticItemCount: Int = 8,
    dynamicItemCount: Int = staticItemCount / 2,
    staticItemColor: Color = SwiftSpinProgressDefaults.StaticItemColor,
    dynamicItemColor: Color = SwiftSpinProgressDefaults.DynamicItemColor,
    spinnerShape: SwiftSpinShape = SwiftSpinShape.RoundedRect,
    durationMillis: Int = 1000,
) {

    //Number of rotating items
    val animatedItemsCount = dynamicItemCount.coerceIn(1, staticItemCount)
    val coefficient = 360f / staticItemCount
    val infiniteTransition = rememberInfiniteTransition("")
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = staticItemCount.toFloat(),
        animationSpec = infiniteRepeatable(
            animation =
                tween(
                    durationMillis = durationMillis,
                    easing = LinearEasing
                ),
            repeatMode = RepeatMode.Restart
        ),
        label = ""
    )

    Canvas(
        modifier = modifier
            .progressSemantics()
            .size(Size)
    ) {
        var canvasWidth = size.width
        var canvasHeight = size.height

        if (canvasHeight < canvasWidth) {
            canvasWidth = canvasHeight
        } else {
            canvasHeight = canvasWidth
        }

        val itemWidth = canvasWidth * 0.3f
        val itemHeight = canvasHeight / staticItemCount
        val cornerRadius = itemWidth.coerceAtMost(itemHeight) / 2
        val horizontalOffset = (size.width - size.height).coerceAtLeast(0f) / 2
        val verticalOffset = (size.height - size.width).coerceAtLeast(0f) / 2
        val topLeftOffset = Offset(
            horizontalOffset + canvasWidth - itemWidth,
            verticalOffset + (canvasHeight - itemHeight) / 2
        )
        val size = Size(itemWidth, itemHeight)
        // Stationary items
        for (i in 0..360 step 360 / staticItemCount) {
            rotate(i.toFloat()) {
                if (spinnerShape == SwiftSpinShape.RoundedRect) {
                    drawRoundRect(
                        color = staticItemColor,
                        topLeft = topLeftOffset,
                        size = size,
                        cornerRadius = CornerRadius(cornerRadius, cornerRadius),
                    )
                } else {
                    drawRect(
                        color = staticItemColor,
                        topLeft = topLeftOffset,
                        size = size,
                    )
                }
            }
        }
        // Dynamic items
        for (i in 0..animatedItemsCount) {
            // angle is cast to move in intervals of static items
            rotate((angle.toInt() + i) * coefficient) {
                if (spinnerShape == SwiftSpinShape.RoundedRect) {
                    drawRoundRect(
                        color = dynamicItemColor.copy(
                            alpha = (1f / dynamicItemCount * i).coerceIn(0f, 1f)
                        ),
                        topLeft = topLeftOffset,
                        size = size,
                        cornerRadius = CornerRadius(cornerRadius, cornerRadius)
                    )
                } else {
                    drawRect(
                        color = dynamicItemColor.copy(
                            alpha = (0.2f + 0.15f * i).coerceIn(0f, 1f)
                        ),
                        topLeft = topLeftOffset,
                        size = size
                    )
                }
            }
        }
    }
}