package io.github.youseflabs.screenutil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import io.github.youseflabs.screenutil.sample.DensityScopeExample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // Initialize ScreenUtil with your design size (from Figma or specs)
                ScreenUtilInit(design = DesignSize(width = 360f, height = 690f)) {
                    DensityScopeExample()
                }
            }
        }
    }
}
