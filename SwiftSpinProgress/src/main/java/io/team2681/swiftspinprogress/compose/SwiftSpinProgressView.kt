package io.team2681.swiftspinprogress.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.team2681.swiftspinprogress.compose.base.SwiftSpinProgressDefaults.DynamicItemColor
import io.team2681.swiftspinprogress.compose.base.SwiftSpinProgressDefaults.StaticItemColor
import io.team2681.swiftspinprogress.compose.base.SwiftSpinProgressIndicator
import io.team2681.swiftspinprogress.compose.base.SwiftSpinShape

@Composable
fun SwiftSpinProgressView(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    staticItemCount: Int = 8,
    dynamicItemCount: Int = staticItemCount / 2,
    spinnerBackgroundColor: Color = Color.Transparent,
    staticItemColor: Color = StaticItemColor,
    dynamicItemColor: Color = DynamicItemColor,
    spinnerShape: SwiftSpinShape = SwiftSpinShape.RoundedRect,
    durationMillis: Int = 1500,
    backgroundOverlayColor: Color = Color.Black.copy(alpha = 0.3f),
    cornerRadius: Dp = 12.dp,
    spinnerContainerSize: Dp = 100.dp,
    spinnerCardElevation: Dp = 4.dp
) {
    if (!isVisible) return

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundOverlayColor),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .size(spinnerContainerSize),
            shape = RoundedCornerShape(cornerRadius),
            elevation = CardDefaults.cardElevation(spinnerCardElevation)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(spinnerBackgroundColor),
                contentAlignment = Alignment.Center
            ) {
                SwiftSpinProgressIndicator(
                    modifier = Modifier,
                    dynamicItemCount = dynamicItemCount,
                    spinnerShape = spinnerShape,
                    staticItemColor = staticItemColor,
                    dynamicItemColor = dynamicItemColor,
                    durationMillis = durationMillis,
                )
            }
        }
    }

}