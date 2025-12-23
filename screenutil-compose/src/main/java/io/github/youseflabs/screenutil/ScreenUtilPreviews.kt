package io.github.youseflabs.screenutil

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
private fun DemoContent() {
    Column(
        Modifier.padding(16.w),
        verticalArrangement = Arrangement.spacedBy(12.h)
    ) {
        Text("Title 20.ssp", fontSize = 20.ssp)
        Text("Body 14.ssp", fontSize = 14.ssp)
        Button(
            onClick = {},
            shape = RoundedCornerShape(10.r),
            modifier = Modifier.height(44.h)
        ) {
            Text("Button", fontSize = 14.ssp)
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.h),
            shape = RoundedCornerShape(16.r)
        ) {
            Box(Modifier.padding(12.w)) {
                Text("Card padding 12.w", fontSize = 14.ssp)
            }
        }
    }
}

@Preview(name = "Design 375x812 - Phone", widthDp = 375, heightDp = 812)
@Composable
fun Preview_DesignSize() {
    ScreenUtilInit(design = DesignSize(375f, 812f)) {
        DemoContent()
    }
}

@Preview(name = "Small Phone", widthDp = 320, heightDp = 640)
@Composable
fun Preview_SmallPhone() {
    ScreenUtilInit(design = DesignSize(375f, 812f)) {
        DemoContent()
    }
}

@Preview(name = "Large Phone", widthDp = 411, heightDp = 891)
@Composable
fun Preview_LargePhone() {
    ScreenUtilInit(design = DesignSize(375f, 812f)) {
        DemoContent()
    }
}

@Preview(name = "Tablet", widthDp = 800, heightDp = 1280)
@Composable
fun Preview_Tablet() {
    ScreenUtilInit(design = DesignSize(375f, 812f)) {
        DemoContent()
    }
}

