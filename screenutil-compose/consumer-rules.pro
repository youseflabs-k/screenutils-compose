# Consumer ProGuard rules for screenutil-compose
# These rules are applied to consuming apps when they minify their code

# Keep all public classes and members
-keep public class io.github.youseflabs.screenutil.** { *; }

# Keep Kotlin extension functions (critical for this library)
-keep class io.github.youseflabs.screenutil.ExtensionsKt { *; }

# Keep all Kotlin metadata for proper extension function resolution
-keepattributes *Annotation*
-keepattributes Signature
-keepattributes InnerClasses
-keepattributes EnclosingMethod

# Keep Composable functions and their metadata
-keep @androidx.compose.runtime.Composable class * { *; }
-keep @androidx.compose.runtime.Composable public class * { *; }
-keep @androidx.compose.runtime.Composable interface * { *; }

# Keep ScreenUtilState and related composables
-keep class io.github.youseflabs.screenutil.ScreenUtilState { *; }
-keep class io.github.youseflabs.screenutil.DesignSize { *; }

# Prevent obfuscation of extension function names
-keepnames class io.github.youseflabs.screenutil.** { *; }
