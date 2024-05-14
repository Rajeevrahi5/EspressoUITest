package com.example.utility

import androidx.test.espresso.Espresso.setFailureHandler
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class ScreenshotTestRule : TestWatcher() {
    override fun starting(description: Description) {
        super.starting(description)
        setFailureHandler(
            CustomFailureHandler(getInstrumentation().targetContext, description)
        )
    }
}