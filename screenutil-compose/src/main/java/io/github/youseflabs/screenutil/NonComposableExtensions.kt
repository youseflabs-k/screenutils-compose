package io.github.youseflabs.screenutil

import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Non-composable extensions that require a Density and ScreenUtilState parameter.
 * Use these when you need scaled values outside of @Composable functions.
 *
 * Example usage:
 * ```kotlin
 * val state = // get your ScreenUtilState
 * val density = // get your Density
 * val width = 16.w(density, state)
 * val fontSize = 14.ssp(density, state)
 * ```
 */

// Width-based scaling
fun Int.w(density: Density, state: ScreenUtilState): Dp = (this * state.scaleW).dp
fun Float.w(density: Density, state: ScreenUtilState): Dp = (this * state.scaleW).dp
fun Double.w(density: Density, state: ScreenUtilState): Dp = (this * state.scaleW).dp

// Height-based scaling
fun Int.h(density: Density, state: ScreenUtilState): Dp = (this * state.scaleH).dp
fun Float.h(density: Density, state: ScreenUtilState): Dp = (this * state.scaleH).dp
fun Double.h(density: Density, state: ScreenUtilState): Dp = (this * state.scaleH).dp

// Radius scaling
fun Int.r(density: Density, state: ScreenUtilState): Dp = (this * state.scaleMin).dp
fun Float.r(density: Density, state: ScreenUtilState): Dp = (this * state.scaleMin).dp
fun Double.r(density: Density, state: ScreenUtilState): Dp = (this * state.scaleMin).dp

// Scaled SP (design-perfect)
fun Int.ssp(density: Density, state: ScreenUtilState): TextUnit = (this * state.scaleMin).sp
fun Float.ssp(density: Density, state: ScreenUtilState): TextUnit = (this * state.scaleMin).sp
fun Double.ssp(density: Density, state: ScreenUtilState): TextUnit = (this * state.scaleMin).sp

// Accessibility-friendly scaled SP
fun Int.sspA11y(density: Density, state: ScreenUtilState): TextUnit = (this * state.scaleMin * density.fontScale).sp
fun Float.sspA11y(density: Density, state: ScreenUtilState): TextUnit = (this * state.scaleMin * density.fontScale).sp
fun Double.sspA11y(density: Density, state: ScreenUtilState): TextUnit = (this * state.scaleMin * density.fontScale).sp

// Design-perfect scaled SP (alias)
fun Int.dsp(density: Density, state: ScreenUtilState): TextUnit = (this * state.scaleMin).sp
fun Float.dsp(density: Density, state: ScreenUtilState): TextUnit = (this * state.scaleMin).sp
fun Double.dsp(density: Density, state: ScreenUtilState): TextUnit = (this * state.scaleMin).sp

// Min/max width scaling
fun Int.mw(density: Density, state: ScreenUtilState): Dp = (this * state.scaleMin).dp
fun Float.mw(density: Density, state: ScreenUtilState): Dp = (this * state.scaleMin).dp
fun Int.xw(density: Density, state: ScreenUtilState): Dp = (this * state.scaleMax).dp
fun Float.xw(density: Density, state: ScreenUtilState): Dp = (this * state.scaleMax).dp

/**
 * Helper extensions that work with raw float values for pixel calculations.
 * These return raw float values instead of Dp/TextUnit, useful for Canvas drawing or low-level operations.
 */

// Raw pixel width scaling
fun Int.wPx(state: ScreenUtilState): Float = this * state.scaleW
fun Float.wPx(state: ScreenUtilState): Float = this * state.scaleW
fun Double.wPx(state: ScreenUtilState): Float = (this * state.scaleW).toFloat()

// Raw pixel height scaling
fun Int.hPx(state: ScreenUtilState): Float = this * state.scaleH
fun Float.hPx(state: ScreenUtilState): Float = this * state.scaleH
fun Double.hPx(state: ScreenUtilState): Float = (this * state.scaleH).toFloat()

// Raw pixel radius scaling
fun Int.rPx(state: ScreenUtilState): Float = this * state.scaleMin
fun Float.rPx(state: ScreenUtilState): Float = this * state.scaleMin
fun Double.rPx(state: ScreenUtilState): Float = (this * state.scaleMin).toFloat()

// Raw pixel text size scaling
fun Int.sspPx(state: ScreenUtilState): Float = this * state.scaleMin
fun Float.sspPx(state: ScreenUtilState): Float = this * state.scaleMin
fun Double.sspPx(state: ScreenUtilState): Float = (this * state.scaleMin).toFloat()

