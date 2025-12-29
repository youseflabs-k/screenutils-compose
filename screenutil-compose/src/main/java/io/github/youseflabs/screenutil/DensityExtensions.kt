package io.github.youseflabs.screenutil

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Scope class that combines Density and ScreenUtilState for non-composable usage.
 * Use this with the `with` function to access .toH and .toW extensions.
 *
 * Example:
 * ```kotlin
 * @Composable
 * fun MyComposable() {
 *     with(LocalDensity.current.withScreenUtil()) {
 *         val height = 100.toH // Converts 100px to height-scaled Dp
 *         val width = 50.toW   // Converts 50px to width-scaled Dp
 *     }
 * }
 * ```
 */
class DensityScreenUtilScope(
    private val densityImpl: Density,
    private val state: ScreenUtilState
) : Density by densityImpl {

    /** Converts Int pixels to height-scaled Dp */
    val Int.toH: Dp
        get() = (this * state.scaleH).dp

    /** Converts Float pixels to height-scaled Dp */
    val Float.toH: Dp
        get() = (this * state.scaleH).dp

    /** Converts Int pixels to width-scaled Dp */
    val Int.toW: Dp
        get() = (this * state.scaleW).dp

    /** Converts Float pixels to width-scaled Dp */
    val Float.toW: Dp
        get() = (this * state.scaleW).dp

    /** Converts Int pixels to radius-scaled Dp (min scale) */
    val Int.toR: Dp
        get() = (this * state.scaleMin).dp

    /** Converts Float pixels to radius-scaled Dp (min scale) */
    val Float.toR: Dp
        get() = (this * state.scaleMin).dp
}

/**
 * Creates a DensityScreenUtilScope for non-composable usage.
 *
 * Example:
 * ```kotlin
 * @Composable
 * fun MyComposable() {
 *     with(LocalDensity.current.withScreenUtil()) {
 *         val height = 100.toH
 *         val width = 50.toW
 *     }
 * }
 * ```
 */
@Composable
fun Density.withScreenUtil(): DensityScreenUtilScope {
    val state = currentScreenUtilState()
    return DensityScreenUtilScope(this, state)
}

/**
 * Non-composable version: Creates a DensityScreenUtilScope with explicit state.
 *
 * Example:
 * ```kotlin
 * @Composable
 * fun MyComposable() {
 *     val state = getScreenUtilState()
 *     val density = LocalDensity.current
 *
 *     LaunchedEffect(Unit) {
 *         with(density.withScreenUtil(state)) {
 *             val height = 100.toH
 *         }
 *     }
 * }
 * ```
 */
fun Density.withScreenUtil(state: ScreenUtilState): DensityScreenUtilScope {
    return DensityScreenUtilScope(this, state)
}

