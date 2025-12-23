package io.github.youseflabs.screenutil

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import kotlin.math.max
import kotlin.math.min

@Immutable
data class ScreenUtilState(
    val design: DesignSize,
    val scaleW: Float,
    val scaleH: Float,
    val scaleMin: Float,
    val scaleMax: Float,
)

private val LocalScreenUtilState = staticCompositionLocalOf<ScreenUtilState> {
    error("ScreenUtil is not initialized. Wrap content with ScreenUtilInit(design=...) { ... }")
}

/**
 * Option A: Pass design size at app start.
 *
 * Uses BoxWithConstraints so it scales using the real available size (better than screenWidthDp).
 */
@Composable
fun ScreenUtilInit(
    design: DesignSize,
    content: @Composable () -> Unit
) {
    BoxWithConstraints {
        val availableW = maxWidth.value
        val availableH = maxHeight.value

        val sw = availableW / design.width
        val sh = availableH / design.height
        val sMin = min(sw, sh)
        val sMax = max(sw, sh)

        val state = remember(design, availableW, availableH) {
            ScreenUtilState(
                design = design,
                scaleW = sw,
                scaleH = sh,
                scaleMin = sMin,
                scaleMax = sMax,
            )
        }

        CompositionLocalProvider(LocalScreenUtilState provides state) {
            content()
        }
    }
}

/** Internal access (useful in tests/previews) */
@Composable
internal fun currentScreenUtilState(): ScreenUtilState = LocalScreenUtilState.current

/**
 * Public access to ScreenUtilState for use with non-composable extensions.
 * Use this when you need to pass state to non-composable functions.
 *
 * Example:
 * ```kotlin
 * @Composable
 * fun MyScreen() {
 *     val state = getScreenUtilState()
 *     val density = LocalDensity.current
 *
 *     LaunchedEffect(Unit) {
 *         val width = 16.w(density, state)
 *         // Use width in non-composable context
 *     }
 * }
 * ```
 */
@Composable
fun getScreenUtilState(): ScreenUtilState = LocalScreenUtilState.current
