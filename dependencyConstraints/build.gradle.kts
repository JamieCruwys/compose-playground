plugins {
    id("java-platform")
}

/**
 * Constraints for dependencies used in a Gradle `dependencies` block. This will apply to transitive dependencies too.
 *
 * See https://docs.gradle.org/current/userguide/dependency_constraints.html#sec:adding-constraints-transitive-deps.
 */
dependencies {
    constraints {
        api("${Libs.ANDROID_TEST_RUNNER}:1.2.0")
        api("${Libs.ANDROID_JUNIT5}:1.2.2")
        api("${Libs.ANDROID_JUNIT5_RUNNER}:1.2.2")
        api("${Libs.APPCOMPAT}:1.3.0")
        api("${Libs.CORE_KTX}:1.5.0")
        api("${Libs.COROUTINES_TEST}:1.5.1")
        api("${Libs.JUNIT5}:5.8.0-M1")
        api("${Libs.KOTLIN_STDLIB}:1.5.10")
        api("${Libs.MATERIAL}:1.3.0")
        api("${Libs.MOCKK}:1.11.0")
        api("${Libs.STRIKT}:0.31.0")
        api("${Libs.TURBINE}:0.5.2")
    }
}
