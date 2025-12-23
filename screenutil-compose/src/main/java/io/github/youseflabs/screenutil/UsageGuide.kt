package io.github.youseflabs.screenutil

/**
 * ScreenUtil Usage Guide
 *
 * 1. Initialize in your MainActivity or App composable:
 *
 * ```kotlin
 * class MainActivity : ComponentActivity() {
 *     override fun onCreate(savedInstanceState: Bundle?) {
 *         super.onCreate(savedInstanceState)
 *
 *         // Set your design size (from Figma or your design specs)
 *         val design = DesignSize(width = 375f, height = 812f)
 *
 *         setContent {
 *             YourAppTheme {
 *                 ScreenUtilInit(design = design) {
 *                     AppNavHost()
 *                 }
 *             }
 *         }
 *     }
 * }
 * ```
 *
 * 2. Use the extensions in your composables:
 *
 * ```kotlin
 * @Composable
 * fun ExampleScreen() {
 *     Column(
 *         modifier = Modifier
 *             .fillMaxSize()
 *             .padding(16.w) // Width-based padding
 *     ) {
 *         Text(
 *             text = "Title",
 *             fontSize = 24.ssp, // Scaled text size
 *             modifier = Modifier.padding(bottom = 8.h) // Height-based spacing
 *         )
 *
 *         Card(
 *             modifier = Modifier
 *                 .fillMaxWidth()
 *                 .height(200.h), // Height-based size
 *             shape = RoundedCornerShape(12.r) // Radius scaling
 *         ) {
 *             // Card content
 *         }
 *
 *         Spacer(modifier = Modifier.height(16.h))
 *
 *         Button(
 *             onClick = { },
 *             modifier = Modifier.height(48.h)
 *         ) {
 *             Text("Button", fontSize = 16.ssp)
 *         }
 *     }
 * }
 * ```
 *
 * 3. Available Extensions:
 *
 * - `.w` - Width-based scaling (use for horizontal spacing, padding)
 * - `.h` - Height-based scaling (use for vertical spacing, heights)
 * - `.r` - Radius scaling (use for corner radius, circular sizes)
 * - `.ssp` - Scaled text size (design-perfect, ignores system font scale)
 * - `.sspA11y` - Scaled text size (accessibility-friendly, respects system font scale)
 * - `.dsp` - Design-perfect text size (same as .ssp)
 * - `.mw` - Min width scaling
 * - `.xw` - Max width scaling
 *
 * 4. Best Practices:
 *
 * - Use `.w` for horizontal dimensions (width, horizontal padding, horizontal margin)
 * - Use `.h` for vertical dimensions (height, vertical padding, vertical margin)
 * - Use `.r` for corner radius and circular elements (consistent across aspect ratios)
 * - Use `.ssp` for most text sizes (keeps design consistent)
 * - Use `.sspA11y` for body text if you want to respect user's accessibility settings
 * - Combine with Material 3 typography tokens for better maintainability
 * - Use WindowSizeClass for major layout changes (phone vs tablet)
 *
 * 5. Testing:
 *
 * You can test different screen sizes using the preview annotations:
 * ```kotlin
 * @Preview(name = "Small Phone", widthDp = 320, heightDp = 640)
 * @Preview(name = "Design Size", widthDp = 375, heightDp = 812)
 * @Preview(name = "Large Phone", widthDp = 411, heightDp = 891)
 * @Preview(name = "Tablet", widthDp = 800, heightDp = 1280)
 * @Composable
 * fun PreviewMyScreen() {
 *     ScreenUtilInit(design = DesignSize(375f, 812f)) {
 *         MyScreen()
 *     }
 * }
 * ```
 */

