plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("io.gitlab.arturbosch.detekt")
    id("com.diffplug.spotless")
    id("org.jmailen.kotlinter")
    id("org.barfuin.gradle.taskinfo") version Versions.TASK_INFO_PLUGIN
    id("com.github.dawnwords.jacoco.badge") version Versions.JACOCO_BADGE
}
apply("$rootDir/quality/setup.gradle")

android {
    compileSdkVersion(Versions.ANDROID_COMPILE_SDK)
    buildToolsVersion = "30.0.3"

    buildFeatures {
        compose = true
    }

    defaultConfig {
        applicationId = "uk.co.jamiecruwys.compose.playground"
        minSdkVersion(Versions.ANDROID_MIN_SDK)
        targetSdkVersion(Versions.ANDROID_TARGET_SDK)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
        }
        getByName("release") {
            isDebuggable = false
            minifyEnabled(false)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    composeOptions {
        kotlinCompilerVersion = Versions.KOTLIN
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }

    packagingOptions {
        exclude("META-INF/**")
    }
}

dependencies {
    implementation(project(":navigation"))

    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.CORE_KTX)
    implementation(Libs.APPCOMPAT)
    implementation(Libs.MATERIAL)
    implementation(Libs.TIMBER)
    implementation(Libs.STARTUP)

    // Dagger hilt
    implementation(Libs.DAGGER_HILT)
    implementation(Libs.DAGGER_HILT_NAVIGATION_COMPOSE)
    kapt(Libs.DAGGER_HILT_COMPILER)
    kapt(Libs.ANDROIDX_DAGGER_HILT_COMPILER)

    // Jetpack Compose
    implementation(Libs.COMPOSE_UI)
    implementation(Libs.COMPOSE_UI_TOOLING)
    implementation(Libs.COMPOSE_FOUNDATION)
    implementation(Libs.COMPOSE_NAVIGATION)
    implementation(Libs.COMPOSE_MATERIAL)
    implementation(Libs.COMPOSE_MATERIAL_ICONS_CORE)
    implementation(Libs.COMPOSE_MATERIAL_ICONS_EXTENDED)
    implementation(Libs.COMPOSE_ACTIVITY)
    implementation(Libs.COMPOSE_VIEWMODEL)
    implementation(Libs.COMPOSE_LIVEDATA)
    implementation(Libs.COMPOSE_THEME_ADAPTER)
    androidTestImplementation(Libs.COMPOSE_UI_TEST_JUNIT)
    debugImplementation(Libs.COMPOSE_UI_TEST_MANIFEST)

    // Accompanist
    implementation(Libs.ACCOMPANIST_SYSTEM_UI_CONTROLLER)
    implementation(Libs.ACCOMPANIST_PLACEHOLDER_MATERIAL)

    // Testing
    testImplementation(Libs.JUNIT)
    androidTestImplementation(Libs.ANDROIDX_JUNIT)
    androidTestImplementation(Libs.ESPRESSO)
}