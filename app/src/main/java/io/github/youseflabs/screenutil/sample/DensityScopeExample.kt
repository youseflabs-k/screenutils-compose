package io.github.youseflabs.screenutil.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.youseflabs.screenutil.*

/**
 * Example demonstrating the usage of toH and toW extensions with Density scope
 */
@Composable
fun DensityScopeExample() {
    ScreenUtilInit(design = DesignSize(width = 375f, height = 812f)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Example 1: Using with(LocalDensity.current.withScreenUtil())
            with(LocalDensity.current.withScreenUtil()) {
                Box(
                    modifier = Modifier
                        .width(100.toW)  // Width-scaled
                        .height(100.toH) // Height-scaled
                        .clip(RoundedCornerShape(20.toR))  // Radius-scaled
                        .background(Color.Blue)
                )
            }

            // Example 2: Using standard extensions
            Box(
                modifier = Modifier
                    .width(100.w)
                    .height(100.h)
                    .clip(RoundedCornerShape(20.r))
                    .background(Color.Green)
            )

            // Example 3: Using composable functions
            Box(
                modifier = Modifier
                    .width(100.toW())
                    .height(100.toH())
                    .background(Color.Red)
            )

            // Example 4: Text with scaled font
            with(LocalDensity.current.withScreenUtil()) {
                Text(
                    text = "Scaled Text Example",
                    fontSize = 16.toW.value.sp
                )
            }
        }
    }
}

