package com.example.basiccalculator


import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.utility.ScreenshotTestRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    var rule = createAndroidComposeRule<MainActivity>()
    @get:Rule
    val screenshotTestRule = ScreenshotTestRule()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.basiccalculator.debug", appContext.packageName)
    }
    @Test
    fun launchCalculatorApp() {
        rule.onNodeWithTag("first_number").assertExists()
        Thread.sleep(5000)
    }
}