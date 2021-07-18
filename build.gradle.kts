buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN}")
        classpath(kotlin("gradle-plugin", Versions.KOTLIN))
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.DAGGER_HILT_PLUGIN}")
        classpath("org.jacoco:org.jacoco.core:${Versions.JACOCO}")
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt") version Versions.DETEKT
    id("com.diffplug.spotless") version Versions.SPOTLESS
    id("org.jmailen.kotlinter") version Versions.KOTLINTER
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
