plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.basiccalculator"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.basiccalculator"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
        /**
         * The `initWith` property lets you copy configurations from other build types,
         * then configure only the settings you want to change. This one copies the debug build
         * type, and then changes the manifest placeholder and application ID.
         */
        create("staging") {
            initWith(getByName("debug"))
            manifestPlaceholders["hostName"] = "com.example.basiccalculator"
            applicationIdSuffix = ".debugStaging"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
/*testOptions {
    animationsDisabled = true
    execution = "ANDROIDX_TEST_ORCHESTRATOR"
    unitTests {
        isReturnDefaultValues = true
        isIncludeAndroidResources = true
    }
    managedDevices {
        devices {
            maybeCreate<com.android.build.api.dsl.ManagedVirtualDevice>("pixel2api30").apply {
                // Use device profiles you typically see in Android Studio.
                device = "Pixel 2"
                // Use only API levels 30 and higher.
                apiLevel = 30
                // To include Google services, use "google".
                systemImageSource = "google"
            }
            maybeCreate<com.android.build.api.dsl.ManagedVirtualDevice>("pixel6api31").apply {
                // Use device profiles you typically see in Android Studio.
                device = "Pixel 6"
                // Use only API levels 30 and higher.
                apiLevel = 31
                // To include Google services, use "google".
                systemImageSource = "google"
            }
        }
    }
}*/

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    //androidTestUtil(libs.androidx.espresso)
}
