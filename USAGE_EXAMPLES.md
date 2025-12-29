# ScreenUtil Compose - Usage Examples

## Extension Properties Usage

### Using `toH` and `toW` with Density Scope

When all your widgets are wrapped by `ScreenUtilInit`, you can use the `toH` and `toW` extension properties within a Density scope:

```kotlin
@Composable
fun MyScreen() {
    // Option 1: Using with(LocalDensity.current.withScreenUtil())
    with(LocalDensity.current.withScreenUtil()) {
        val height = 100.toH  // Converts 100 to height-scaled Dp
        val width = 50.toW    // Converts 50 to width-scaled Dp
        val radius = 20.toR   // Converts 20 to radius-scaled Dp (min scale)
        
        Box(
            modifier = Modifier
                .width(width)
                .height(height)
        )
    }
}
```

### Using in Non-Composable Context

For non-composable contexts (like LaunchedEffect, coroutines, etc.):

```kotlin
@Composable
fun MyScreen() {
    val state = getScreenUtilState()
    val density = LocalDensity.current
    
    LaunchedEffect(Unit) {
        with(density.withScreenUtil(state)) {
            val height = 100.toH
            val width = 50.toW
            // Use these values in your non-composable code
        }
    }
}
```

### Direct Composable Extensions

If you prefer direct usage without the `with` scope:

```kotlin
@Composable
fun MyScreen() {
    val height = 100.toH()  // Composable function
    val width = 50.toW()    // Composable function
    
    Box(
        modifier = Modifier
            .width(width)
            .height(height)
    )
}
```

## Standard Extensions

### Width-based scaling (.w)
```kotlin
@Composable
fun MyScreen() {
    Box(modifier = Modifier.width(100.w))  // Scales based on width
}
```

### Height-based scaling (.h)
```kotlin
@Composable
fun MyScreen() {
    Box(modifier = Modifier.height(100.h))  // Scales based on height
}
```

### Radius scaling (.r)
```kotlin
@Composable
fun MyScreen() {
    Box(
        modifier = Modifier
            .size(100.w, 100.h)
            .clip(RoundedCornerShape(20.r))  // Consistent across aspect ratios
    )
}
```

### Font scaling
```kotlin
@Composable
fun MyScreen() {
    // Design-perfect (ignores system font scale)
    Text("Hello", fontSize = 16.ssp)
    
    // Accessibility-friendly (respects system font scale)
    Text("Hello", fontSize = 16.sspA11y)
}
```

