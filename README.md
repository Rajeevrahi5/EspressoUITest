# EspressoUITest
This repository explains how to write Espresso UI test with Jetpack Compose
## Important gradlew command
- Run test by command line
- ./gradlew connectedDebugAndroidTest -Pandroid.testoptions.manageddevices.emulator.gpu=swiftshader_indirect -Pandroid.testInstrumentationRunnerArguments.notAnnotation=org.junit.Ignore -Pandroid.testInstrumentationRunnerArguments.class=com.example.basiccalculator.ExampleInstrumentedTest

