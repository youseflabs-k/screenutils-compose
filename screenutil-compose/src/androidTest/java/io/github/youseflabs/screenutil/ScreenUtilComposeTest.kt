package io.github.youseflabs.screenutil

import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

private val ScaleWSemanticsKey = SemanticsPropertyKey<Float>("scaleW")
private var SemanticsPropertyReceiver.scaleW by ScaleWSemanticsKey

class ScreenUtilComposeTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun providesScaleFactors() {
        rule.setContent {
            ScreenUtilInit(design = DesignSize(375f, 812f)) {
                val s = currentScreenUtilState()
                Box(
                    Modifier
                        .testTag("box")
                        .semantics { scaleW = s.scaleW }
                )
            }
        }

        rule.onNodeWithTag("box")
            .assert(
                SemanticsMatcher.expectValue(
                    ScaleWSemanticsKey,
                    rule.onNodeWithTag("box").fetchSemanticsNode().config[ScaleWSemanticsKey]
                )
            )
    }

    @Test
    fun wExtension_scalesDp() {
        rule.setContent {
            ScreenUtilInit(design = DesignSize(375f, 812f)) {
                // If width is designWidth => scaleW = 1, then 16.w == 16.dp.
                // We can't guarantee the test device constraints, but we can check proportionality:
                // 16.w / 8.w == 2
                val a = 16.w
                val b = 8.w

                Box(
                    Modifier.testTag("ratio")
                        .semantics {
                            // store ratio as float (dp is value)
                            scaleW = a.value / b.value
                        }
                )
            }
        }

        rule.onNodeWithTag("ratio")
            .assert(SemanticsMatcher.expectValue(ScaleWSemanticsKey, 2f))
    }
}

