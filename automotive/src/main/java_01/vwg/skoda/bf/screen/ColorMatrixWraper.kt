package vwg.skoda.bf.screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Paint
import vwg.skoda.bf.holders.ColorMatrixHolder


@Composable
fun ColorMartixWraper(content: @Composable
    () -> Unit) {
    val matrixValues = ColorMatrixHolder.matrixValues
    val matrix = remember(matrixValues.toList()) {
        ColorMatrixHolder.asColorMatrix()
    }

    Box(
        modifier = Modifier.drawWithContent {
            with(drawContext.canvas) {
                val bounds = Rect(0f, 0f, size.width, size.height)
                saveLayer(bounds, Paint().apply {
                    colorFilter = ColorFilter.colorMatrix(matrix)
                })
                drawContent()
                restore()
            }
        }
    ) {
        content()
    }
}
