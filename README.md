# ScreenUtil Compose

Responsive scaling utilities for Jetpack Compose, inspired by Flutter’s ScreenUtil.  
Scale dimensions, padding, radius, and text sizes from a fixed **design size** to any device size.

## Features
- Width/height/radius scaling: `.w`, `.h`, `.r`
- Text scaling:
    - `.ssp` (scaled, design-perfect)
    - `.sspA11y` (scaled + respects system font scale)
    - `.dsp` (design-perfect, ignores system font scale)
- Simple root initialization with `ScreenUtilInit(design = DesignSize(...))`
- Works with Material 3 + previews

---

## Install

### Maven Central
Add the dependency to your `build.gradle`:

```kotlin
dependencies {
  implementation("io.github.youseflabs:screenutil-compose:<version>")
}
```

Replace `<version>` with the latest release from [Releases](https://github.com/Ahmedmmy97/screenutils-compose/releases).

### GitHub Packages
Add the GitHub Packages repository to your `settings.gradle.kts` or `build.gradle`:

```kotlin
repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/Ahmedmmy97/screenutils-compose")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
        }
    }
}
```

Then add the dependency:

```kotlin
dependencies {
  implementation("io.github.youseflabs:screenutil-compose:<version>")
}
```

---

## Quick start

1) **Initialize once (e.g., MainActivity)**

```kotlin
import io.github.youseflabs.screenutil.DesignSize
import io.github.youseflabs.screenutil.ScreenUtilInit

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ScreenUtilInit(design = DesignSize(width = 360f, height = 690f)) {
        App()
      }
    }
  }
}
```

2) **Use extensions**

```kotlin
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.youseflabs.screenutil.*

@Composable
fun ExampleScreen() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.w)
  ) {
    Text(
      text = "Title",
      fontSize = 24.ssp,
      modifier = Modifier.padding(bottom = 8.h)
    )
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .height(200.h),
      shape = RoundedCornerShape(12.r)
    ) {
      // content
    }
    Spacer(modifier = Modifier.height(16.h))
    Button(
      onClick = {},
      modifier = Modifier.height(48.h)
    ) {
      Text("Button", fontSize = 16.ssp)
    }
  }
}
```

---

## Extensions
- `.w` — width-based scaling
- `.h` — height-based scaling
- `.r` — radius scaling (uses min scale)
- `.ssp` — scaled text (design-perfect)
- `.sspA11y` — scaled text (accessibility-friendly: respects system font scale)
- `.dsp` — design-perfect text (ignores system font scale)
- `.mw` — min-scale dp helper (optional)
- `.xw` — max-scale dp helper (optional)

---

## Previews

```kotlin
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "Small Phone", widthDp = 320, heightDp = 640)
@Preview(name = "Design Size", widthDp = 360, heightDp = 690)
@Preview(name = "Large Phone", widthDp = 411, heightDp = 891)
@Preview(name = "Tablet", widthDp = 800, heightDp = 1280)
@Composable
fun PreviewExampleScreen() {
  ScreenUtilInit(design = DesignSize(360f, 690f)) {
    ExampleScreen()
  }
}
```

---

## Best practices
- Use `.w` for horizontal padding/widths
- Use `.h` for vertical spacing/heights
- Use `.r` for corner radius / circular shapes
- Prefer `.sspA11y` for user-facing text if accessibility matters
- Use WindowSizeClass for major layout changes (phone vs tablet)

---

## Release info
- **Group:** `io.github.youseflabs`
- **Artifact:** `screenutil-compose`
- **Repository:** [Ahmedmmy97/screenutils-compose](https://github.com/Ahmedmmy97/screenutils-compose)

---

## ProGuard

No special rules are required for typical usage.
If your setup aggressively shrinks/obfuscates and you need a keep rule:

```
-keep class io.github.youseflabs.screenutil.** { *; }
```

---

## License

MIT
