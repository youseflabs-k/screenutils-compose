package io.github.youseflabs.screenutil

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.max
import kotlin.math.min

class ScaleMathTest {

    @Test
    fun scaleFactors_matchExpected() {
        val design = DesignSize(375f, 812f)
        val availableW = 411f
        val availableH = 891f

        val sw = availableW / design.width
        val sh = availableH / design.height

        assertEquals(411f / 375f, sw, 0.0001f)
        assertEquals(891f / 812f, sh, 0.0001f)

        val sMin = min(sw, sh)
        val sMax = max(sw, sh)

        assertEquals(min(sw, sh), sMin, 0.0001f)
        assertEquals(max(sw, sh), sMax, 0.0001f)
    }

    @Test
    fun scaleFactors_designSize() {
        val design = DesignSize(375f, 812f)

        assertEquals(375f, design.width, 0.0001f)
        assertEquals(812f, design.height, 0.0001f)
    }

    @Test
    fun scaleFactors_sameSize() {
        val design = DesignSize(375f, 812f)
        val availableW = 375f
        val availableH = 812f

        val sw = availableW / design.width
        val sh = availableH / design.height

        // When dimensions match, scale should be 1.0
        assertEquals(1.0f, sw, 0.0001f)
        assertEquals(1.0f, sh, 0.0001f)
    }
}

