package io.github.youseflabs.screenutil

import android.os.Bundle
import androidx.activity.ComponentActivity
import io.github.youseflabs.screenutil.sample.SampleScreen
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import io.github.youseflabs.screenutil.ScreenUtilInit
import io.github.youseflabs.screenutil.DesignSize

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val composeView = ComposeView(this)
        composeView.setContent {
            MaterialTheme {
                // Initialize ScreenUtil with your design size (from Figma or specs)
                ScreenUtilInit(design = DesignSize(width = 360f, height = 690f)) {
                    SampleScreen()
                }
            }
        }
        setContentView(composeView)
    }
}
