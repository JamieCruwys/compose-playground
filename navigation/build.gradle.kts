plugins {
    id("com.android.library")
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
        minSdkVersion(Versions.ANDROID_MIN_SDK)
        targetSdkVersion(Versions.ANDROID_TARGET_SDK)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.CORE_KTX)
    implementation(Libs.APPCOMPAT)
    implementation(Libs.TIMBER)

    // Dagger hilt
    implementation(Libs.DAGGER_HILT)
    implementation(Libs.DAGGER_HILT_NAVIGATION_COMPOSE)
    kapt(Libs.DAGGER_HILT_COMPILER)
    kapt(Libs.ANDROIDX_DAGGER_HILT_COMPILER)

    // Jetpack Compose
    implementation(Libs.COMPOSE_NAVIGATION)

    // Testing
    testImplementation(Libs.JUNIT)
    androidTestImplementation(Libs.ANDROIDX_JUNIT)
    androidTestImplementation(Libs.ESPRESSO)
}