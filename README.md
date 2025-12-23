<div align="center">

# 📱 ScreenUtil Compose

[![Maven Central](https://img.shields.io/maven-central/v/io.github.youseflabs-k/screenutil-compose?color=blue&label=Maven%20Central)](https://central.sonatype.com/artifact/io.github.youseflabs-k/screenutil-compose)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![API](https://img.shields.io/badge/API-23%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=23)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0%2B-blue.svg?style=flat&logo=kotlin)](https://kotlinlang.org)

**Responsive scaling utilities for Jetpack Compose**  
*Inspired by Flutter's ScreenUtil*

Scale dimensions, padding, radius, and text sizes from a fixed design size to any device size with ease.

[Installation](#-installation) •
[Quick Start](#-quick-start) •
[Features](#-features) •
[Examples](#-examples) •
[API Reference](#-api-reference)

</div>

---

## ✨ Features

- 🎯 **Design-Perfect Scaling** - Scale from your designer's specs (e.g., 360×690) to any device
- 📐 **Dimension Extensions** - `.w`, `.h`, `.r` for width, height, and radius scaling
- 🔤 **Text Scaling Options**:
  - `.ssp` - Scaled, design-perfect text
  - `.sspA11y` - Scaled + respects system font scale (accessibility-friendly)
  - `.dsp` - Design-perfect, ignores system font scale
- 🎨 **Material 3 Ready** - Works seamlessly with Material Design 3
- 👀 **Preview Support** - Full support for Compose previews
- 🪶 **Lightweight** - Zero dependencies beyond Compose
- ⚡ **Simple API** - One-time initialization, extension-based usage

---

## 📦 Installation

### Maven Central

Add the dependency to your module's `build.gradle.kts`:

```kotlin
dependencies {
    implementation("io.github.youseflabs-k:screenutil-compose:<latest-version>")
}
```

<details>
<summary><b>Gradle (Groovy)</b></summary>

```groovy
dependencies {
    implementation 'io.github.youseflabs-k:screenutil-compose:<latest-version>'
}
```
</details>

> **Latest Version:** Check [Releases](https://github.com/youseflabs-k/screenutils-compose/releases) for the most recent version.

---

## 🚀 Quick Start

### 1. Initialize in Your Activity

Wrap your app's content with `ScreenUtilInit` and specify your design size:

```kotlin
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.os.Bundle
import io.github.youseflabs.screenutil.DesignSize
import io.github.youseflabs.screenutil.ScreenUtilInit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenUtilInit(design = DesignSize(width = 360f, height = 690f)) {
                MyApp()
            }
        }
    }
}
```

### 2. Use Extensions in Your Composables

```kotlin
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.youseflabs.screenutil.*

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.w)  // ✨ Scales based on design width
    ) {
        Text(
            text = "Welcome Back!",
            fontSize = 24.ssp,  // ✨ Scales text perfectly
            modifier = Modifier.padding(bottom = 8.h)  // ✨ Scales based on design height
        )
        
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.h),  // ✨ Scales height
            shape = RoundedCornerShape(12.r)  // ✨ Scales radius
        ) {
            // Card content
        }
        
        Spacer(modifier = Modifier.height(16.h))
        
        Button(
            onClick = { /* Handle click */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.h)
        ) {
            Text("Get Started", fontSize = 16.ssp)
        }
    }
}
```

That's it! Your UI will now scale proportionally across all device sizes. 🎉

---

## 📚 Examples

### Responsive Layouts

```kotlin
@Composable
fun ResponsiveCard() {
    Card(
        modifier = Modifier
            .width(300.w)       // Scales to device width
            .height(400.h),     // Scales to device height
        shape = RoundedCornerShape(16.r),  // Scales radius
        elevation = CardDefaults.cardElevation(defaultElevation = 4.r)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.w, vertical = 16.h)
        ) {
            Text("Title", fontSize = 20.ssp)
            Spacer(modifier = Modifier.height(8.h))
            Text("Description", fontSize = 14.ssp)
        }
    }
}
```

### Accessibility-Friendly Text

```kotlin
@Composable
fun AccessibleText() {
    Column {
        // Design-perfect text (ignores system font scale)
        Text(
            text = "Design Perfect",
            fontSize = 16.ssp
        )
        
        // Accessibility-friendly (respects system font scale)
        Text(
            text = "Accessible Text",
            fontSize = 16.sspA11y
        )
        
        // Fully design-perfect (ignores all scaling)
        Text(
            text = "Fixed Size",
            fontSize = 16.dsp
        )
    }
}
```

### Preview Support

Test your UI across different device sizes:

```kotlin
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "Small Phone", widthDp = 320, heightDp = 640)
@Preview(name = "Design Size", widthDp = 360, heightDp = 690)
@Preview(name = "Large Phone", widthDp = 411, heightDp = 891)
@Preview(name = "Tablet", widthDp = 800, heightDp = 1280)
@Composable
fun PreviewProfileScreen() {
    ScreenUtilInit(design = DesignSize(360f, 690f)) {
        ProfileScreen()
    }
}
```

---

## 📖 API Reference

### Initialization

#### `ScreenUtilInit`
Initialize the scaling system with your design dimensions.

```kotlin
@Composable
fun ScreenUtilInit(
    design: DesignSize,
    content: @Composable () -> Unit
)
```

**Parameters:**
- `design: DesignSize` - Your design's base dimensions (e.g., `DesignSize(360f, 690f)`)
- `content` - Your app's composable content

### Extension Properties

| Extension | Type | Description | Use Case |
|-----------|------|-------------|----------|
| `.w` | `Dp` | Width-based scaling | Horizontal padding, widths |
| `.h` | `Dp` | Height-based scaling | Vertical spacing, heights |
| `.r` | `Dp` | Radius scaling (min scale) | Corner radius, circular shapes |
| `.ssp` | `TextUnit` | Scaled text (design-perfect) | Body text, headers |
| `.sspA11y` | `TextUnit` | Scaled text + system font scale | Accessibility-friendly text |
| `.dsp` | `TextUnit` | Design-perfect text | Fixed-size text (logos, icons) |
| `.mw` | `Dp` | Min-scale dp | Optional minimum scaling |
| `.xw` | `Dp` | Max-scale dp | Optional maximum scaling |

### Usage Examples

```kotlin
// Dimensions
Modifier.padding(16.w)              // Width-based
Modifier.height(48.h)               // Height-based
RoundedCornerShape(12.r)            // Radius

// Text
fontSize = 16.ssp                   // Scaled text
fontSize = 16.sspA11y               // Accessible text
fontSize = 16.dsp                   // Design-perfect text
```

---

## 💡 Best Practices

### ✅ Do's

- ✅ Use `.w` for horizontal padding, widths, and spacing
- ✅ Use `.h` for vertical spacing, heights, and offsets
- ✅ Use `.r` for corner radius and circular shapes
- ✅ Prefer `.sspA11y` for user-facing text to support accessibility
- ✅ Use `WindowSizeClass` for major layout changes (phone vs tablet)
- ✅ Test your UI with different preview sizes
- ✅ Initialize `ScreenUtilInit` once at the root level

### ❌ Don'ts

- ❌ Don't use `.w` for vertical measurements (use `.h` instead)
- ❌ Don't over-scale everything - use `fillMaxWidth()`, `fillMaxHeight()` where appropriate
- ❌ Don't use `.ssp` if you need accessibility support (use `.sspA11y` instead)
- ❌ Don't initialize `ScreenUtilInit` multiple times in the same composition tree

---

## 🔧 Configuration

### Custom Design Sizes

Choose a design size that matches your designer's mockups:

```kotlin
// Common design sizes
ScreenUtilInit(design = DesignSize(360f, 690f))  // Small phone (default)
ScreenUtilInit(design = DesignSize(375f, 812f))  // iPhone X/11/12
ScreenUtilInit(design = DesignSize(414f, 896f))  // Large phone
ScreenUtilInit(design = DesignSize(768f, 1024f)) // Tablet
```

---

## 🛡️ ProGuard / R8

**No configuration needed!** The library automatically includes consumer ProGuard rules.

Your extension functions will work correctly even when your app is minified/obfuscated.

<details>
<summary><b>If you encounter issues (click to expand)</b></summary>

If you're using aggressive ProGuard/R8 configuration and extensions aren't working, add:

```proguard
# ScreenUtil Compose
-keep class io.github.youseflabs.screenutil.** { *; }
-keep class io.github.youseflabs.screenutil.ExtensionsKt { *; }
```

</details>

---

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

## 📄 License

```
MIT License

Copyright (c) 2025 Ahmed Yousef

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---

## 🔗 Links

- **Repository:** [github.com/youseflabs-k/screenutils-compose](https://github.com/youseflabs-k/screenutils-compose)
- **Issues:** [github.com/youseflabs-k/screenutils-compose/issues](https://github.com/youseflabs-k/screenutils-compose/issues)
- **Releases:** [github.com/youseflabs-k/screenutils-compose/releases](https://github.com/youseflabs-k/screenutils-compose/releases)
- **Maven Central:** [central.sonatype.com/artifact/io.github.youseflabs-k/screenutil-compose](https://central.sonatype.com/artifact/io.github.youseflabs-k/screenutil-compose)

---

<div align="center">

**Made with ❤️ by [Ahmed Yousef](https://github.com/youseflabs-k)**

If you find this library helpful, please consider giving it a ⭐️!

</div>

