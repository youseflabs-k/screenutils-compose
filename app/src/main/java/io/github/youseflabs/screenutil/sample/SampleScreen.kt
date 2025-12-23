package io.github.youseflabs.screenutil.sample

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.github.youseflabs.screenutil.DesignSize
import io.github.youseflabs.screenutil.ScreenUtilInit
import io.github.youseflabs.screenutil.h
import io.github.youseflabs.screenutil.w


@Composable
fun SampleScreen() {
    ScreenUtilInit(design = DesignSize(width = 360f, height = 690f)) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.w),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "ScreenUtil Sample",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF6200EE)
                )
                Spacer(modifier = Modifier.height(24.h))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(200.w)
                        .height(48.h)
                ) {
                    Text(text = "Responsive Button", fontSize = 16.sp)
                }
            }
        }
    }
}

