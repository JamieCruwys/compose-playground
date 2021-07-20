# compose-playground
Jetpack Compose playground

## Reading list
* [x] [Compose docs](https://developer.android.com/jetpack/compose/testing)
* [x] [Compose docs - semantics](https://developer.android.com/jetpack/compose/accessibility#semantics)
* [ ] [Jetpack Compose: Screencasts](https://www.youtube.com/playlist?list=PLWz5rJ2EKKc8fZY3smX9CPx9Y_O80ycAd) - TODO: Lists & State
* [x] [What's new in Jetpack Compose](https://www.youtube.com/watch?v=7Mf2175h3RQ&t=945s)
* [ ] [Compose pathway](https://developer.android.com/courses/pathways/compose) - Got to step 4
* [x] [Thinking in Compose](https://developer.android.com/jetpack/compose/mental-model)
* [x] [State and Jetpack Compose](https://developer.android.com/jetpack/compose/state)
* [ ] [Guide to app architecture](https://developer.android.com/jetpack/guide)
* [x] [Jetpack Compose: Lists](https://www.youtube.com/watch?v=BhqPpUYJYeQ)
* [x] [State and Jetpack Compose (ViewModels)](https://developer.android.com/jetpack/compose/state#viewmodel-state)
* [x] [Jetpack Compose and Hilt](https://developer.android.com/jetpack/compose/libraries#hilt)
* [ ] [Using Jetpack libraries in Compose](https://www.youtube.com/watch?v=0z_dwBGQQWQ&t=573s)
* [x] [Exploring Jetpack Compose: TopAppBar](https://medium.com/google-developer-experts/exploring-jetpack-compose-topappbar-c8b79893be34)
* [ ] [Navigating with Compose](https://developer.android.com/jetpack/compose/navigation)
* [ ] [Theming in Compose](https://developer.android.com/jetpack/compose/themes)
* [ ] [Modular navigation with Jetpack Compose](https://joebirch.co/android/modular-navigation-with-jetpack-compose/)

## References
* [Compose samples](https://github.com/android/compose-samples)
* [Compose Cookbook repo](https://github.com/Gurupreet/ComposeCookBook)
* [Testing cheatsheet](https://developer.android.google.cn/jetpack/compose/testing-cheatsheet)
* [Compose Academy](https://compose.academy/)

## Compose YouTube videos
* [Declarative UI Patterns (Google I/O'19)](https://www.youtube.com/watch?v=VsStyq4Lzxo)
* [Android Developers - Compose videos](https://www.youtube.com/c/AndroidDevelopers/search?query=compose)

## Useful libraries
* [Accompanist Guide](https://google.github.io/accompanist/)
* [Accompanist GitHub](https://github.com/google/accompanist)

## Code quality

The following code quality tools are used:

* [Detekt](https://github.com/detekt/detekt) - Static code analysis for Kotlin code
* [Spotless](https://github.com/diffplug/spotless) - Formats code
* [Kotlinter](https://github.com/jeremymailen/kotlinter-gradle) - Static code analysis using [ktlint](https://github.com/pinterest/ktlint)
* [Android lint](http://tools.android.com/tips/lint) - scans Android code for bugs
* [Jacoco](https://github.com/jacoco/jacoco) - Code coverage
* [Jacoco Badge](https://github.com/dawnwords/jacoco-badge-gradle-plugin) - Code coverage badge

How to run the code quality tools:

* Run `./gradlew check` to run all checks
* Run `./gradlew detekt` to run Detekt
* Run `./gradlew spotlessCheck` to run Spotless
* Run `./gradlew spotlessApply` to automatically apply Spotless suggestions
* Run `./gradlew lintKotlin` to run ktlint via Kotlinter
* Run `./gradlew lint` to run Android lint

Generating code coverage tasks:

* Run `./gradlew testDebugUnitTestCoverage` to generate debug test coverage
* Run `./gradlew testReleaseUnitTestCoverage` to generate release  test coverage

Code coverage verification tasks:

* Run `./gradlew testDebugUnitTestCoverageVerification` to generate debug test coverage and verify the results
* Run `./gradlew testReleaseUnitTestCoverageVerification` to generate release test coverage and verify the results

Code coverage badge task:

* Run `./generateJacocoBadge` to update the code coverage badges in this readme. It can only be based on one report, so I chose the release build.

## How to update Gradle version

Read the docs:
https://docs.gradle.org/current/userguide/gradle_wrapper.html

`./gradlew wrapper --gradle-version 7.1.1`