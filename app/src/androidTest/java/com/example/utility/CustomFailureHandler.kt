package com.example.utility

import android.content.Context
import android.view.View

import androidx.test.espresso.FailureHandler
import androidx.test.espresso.base.DefaultFailureHandler
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import org.hamcrest.Matcher
import org.junit.runner.Description
import java.io.File

class CustomFailureHandler(targetContext: Context, description: Description) : FailureHandler {

    private val delegate: FailureHandler
    private val device = UiDevice.getInstance(getInstrumentation())
    private val directory = "/sdcard/screenshots"
    private val testClassName = description.className
    private val testMethodName = description.methodName

    init {
        delegate = DefaultFailureHandler(targetContext)
    }

    override fun handle(error: Throwable, viewMatcher: Matcher<View>) {
        val snapshot = File("$directory/$testClassName", "$testMethodName.png")
        snapshot.parentFile!!.mkdirs()
        device.takeScreenshot(snapshot)

        delegate.handle(error, viewMatcher)
    }
}