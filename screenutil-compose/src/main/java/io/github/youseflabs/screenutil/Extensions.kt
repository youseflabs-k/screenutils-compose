package io.github.youseflabs.screenutil
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Width-based scaling like Flutter ScreenUtil: setWidth / .w
 */
val Int.w: Dp
    @Composable get() = (this * currentScreenUtilState().scaleW).dp

val Float.w: Dp
    @Composable get() = (this * currentScreenUtilState().scaleW).dp

val Double.w: Dp
    @Composable get() = (this * currentScreenUtilState().scaleW).dp

/**
 * Height-based scaling like ScreenUtil: setHeight / .h
 */
val Int.h: Dp
    @Composable get() = (this * currentScreenUtilState().scaleH).dp

val Float.h: Dp
    @Composable get() = (this * currentScreenUtilState().scaleH).dp

val Double.h: Dp
    @Composable get() = (this * currentScreenUtilState().scaleH).dp

/**
 * Radius scaling: typically uses min scale so it looks consistent across aspect ratios.
 */
val Int.r: Dp
    @Composable get() = (this * currentScreenUtilState().scaleMin).dp

val Float.r: Dp
    @Composable get() = (this * currentScreenUtilState().scaleMin).dp

val Double.r: Dp
    @Composable get() = (this * currentScreenUtilState().scaleMin).dp

/**
 * Scaled SP (ScreenUtil-style) - Design-perfect (ignores system fontScale).
 * Note: This ignores system fontScale on purpose (design-perfect).
 * If you want accessibility-aware scaling, use .sspA11y instead.
 */
val Int.ssp: TextUnit
    @Composable get() = (this * currentScreenUtilState().scaleMin).sp

val Float.ssp: TextUnit
    @Composable get() = (this * currentScreenUtilState().scaleMin).sp

val Double.ssp: TextUnit
    @Composable get() = (this * currentScreenUtilState().scaleMin).sp

/**
 * Accessibility-friendly scaled SP (respects system font scale).
 */
val Int.sspA11y: TextUnit
    @Composable get() {
        val s = currentScreenUtilState()
        val fontScale = LocalDensity.current.fontScale
        return (this * s.scaleMin * fontScale).sp
    }

val Float.sspA11y: TextUnit
    @Composable get() {
        val s = currentScreenUtilState()
        val fontScale = LocalDensity.current.fontScale
        return (this * s.scaleMin * fontScale).sp
    }

val Double.sspA11y: TextUnit
    @Composable get() {
        val s = currentScreenUtilState()
        val fontScale = LocalDensity.current.fontScale
        return (this * s.scaleMin * fontScale).sp
    }

/**
 * Design-perfect scaled SP (alias for clarity - ignores system fontScale).
 */
val Int.dsp: TextUnit
    @Composable get() = (this * currentScreenUtilState().scaleMin).sp

val Float.dsp: TextUnit
    @Composable get() = (this * currentScreenUtilState().scaleMin).sp

val Double.dsp: TextUnit
    @Composable get() = (this * currentScreenUtilState().scaleMin).sp

/**
 * Optional helpers if you want min/max dp scaling.
 */
val Int.mw: Dp
    @Composable get() = (this * currentScreenUtilState().scaleMin).dp

val Float.mw: Dp
    @Composable get() = (this * currentScreenUtilState().scaleMin).dp

val Int.xw: Dp
    @Composable get() = (this * currentScreenUtilState().scaleMax).dp

val Float.xw: Dp
    @Composable get() = (this * currentScreenUtilState().scaleMax).dp

/**
 * Converts raw pixels (Int) to height-scaled Dp.
 * Similar to Density.toDp() but applies height scaling.
 *
 * Example:
 * ```kotlin
 * val density = LocalDensity.current
 * val scaledHeight = 100.toH(density) // Converts 100px to height-scaled Dp
 * ```
 */
@Composable
fun Int.toH(): Dp {
    val density = LocalDensity.current.density
    return (this / density).h
}

/**
 * Converts raw pixels (Float) to height-scaled Dp.
 * Similar to Density.toDp() but applies height scaling.
 */
@Composable
fun Float.toH(): Dp {
    val density = LocalDensity.current.density
    return (this / density).h
}

/**
 * Converts raw pixels (Int) to width-scaled Dp.
 * Similar to Density.toDp() but applies width scaling.
 */
@Composable
fun Int.toW(): Dp {
    val density = LocalDensity.current.density
    return (this / density).w
}

/**
 * Converts raw pixels (Float) to width-scaled Dp.
 * Similar to Density.toDp() but applies width scaling.
 */
@Composable
fun Float.toW(): Dp {
    val density = LocalDensity.current.density
    return (this / density).w
}

