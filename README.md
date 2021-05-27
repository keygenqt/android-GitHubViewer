GitHub Viewer
===================

![picture](data/preview.png)

Implementation of the application using the latest Android stack as of early summer 2021 and the [GitHub REST API](https://docs.github.com/en/rest).

```xml
<!-- Github login. You can change the user to your own-->
<string name="github_user">keygenqt</string>
```

### Architecture

* MVVM - [Guide to app architecture](https://developer.android.com/jetpack/guide)
* [Kotlin](https://kotlinlang.org/) 100%, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines),
  [Flow](https://kotlinlang.org/docs/flow.html)

### Preview
![Light](data/vokoscreen-2021-05-27_10-15-23.mp4)
![Dark](data/vokoscreen-2021-05-27_10-17-04.mp4)

### Libraries

* Accompanist
    * [Accompanist Insets](https://github.com/google/accompanist)
    * [Glide for Jetpack Compose](https://google.github.io/accompanist/glide/)
    * [Swipe Refresh](https://google.github.io/accompanist/swiperefresh/)
* Jetpack Compose
    * [Compose Material Components](https://mvnrepository.com/artifact/androidx.compose.material/material)
    * [Material Icons Extended by Infragistics](https://github.com/IgniteUI/material-icons-extended)
    * [Compose UI Primitives](https://developer.android.com/jetpack/androidx/releases/compose-ui)
    * [Compose Layouts](https://mvnrepository.com/artifact/androidx.compose.foundation/foundation-layout)
    * [ConstraintLayout Compose](https://developer.android.com/jetpack/androidx/releases/constraintlayout)
    * [Paging Compose](https://developer.android.com/jetpack/androidx/releases/paging)
    * [Compose tooling](https://developer.android.com/jetpack/compose/tooling)
    * [Runtime LiveData Compose](https://developer.android.com/jetpack/androidx/releases/compose-runtime#declaring_dependencies)
    * [Navigation Compose Hilt Extension](https://mvnrepository.com/artifact/androidx.hilt/hilt-navigation-compose)
* Di
    * [Hilt Compiler](https://developer.android.com/training/dependency-injection/hilt-jetpack#workmanager)
    * [Hilt Android](https://mvnrepository.com/artifact/com.google.dagger/hilt-android)
    * [Hilt Processor](https://mvnrepository.com/artifact/com.google.dagger/hilt-compiler)
* Retrofit2 & OkHttp3
    * [Converter: Gson](https://mvnrepository.com/artifact/com.squareup.retrofit2/converter-gson)
    * [Retrofit](https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit)
    * [OkHttp Logging Interceptor](https://mvnrepository.com/artifact/com.squareup.okhttp3/logging-interceptor)
* Room
    * [Android Room Runtime](https://mvnrepository.com/artifact/androidx.room/room-runtime)
    * [Android Room Kotlin Extensions](https://mvnrepository.com/artifact/androidx.room/room-ktx)
    * [Android Room Compiler](https://mvnrepository.com/artifact/androidx.room/room-compiler)
* Security
    * [AndroidX Security](https://mvnrepository.com/artifact/androidx.security/security-crypto)
    * [AndroidX Security](https://mvnrepository.com/artifact/androidx.security/security-identity-credential)
* Test
    * [JUnit](https://mvnrepository.com/artifact/junit/junit)
    * [Android JUnit](https://mvnrepository.com/artifact/androidx.test.ext/junit)
    * [Compose Testing For JUnit4](https://mvnrepository.com/artifact/androidx.compose.ui/ui-test-junit4)
    * [AndroidX Test Library](https://mvnrepository.com/artifact/androidx.test.espresso/espresso-core)
    * [Hilt Android Testing](https://mvnrepository.com/artifact/com.google.dagger/hilt-android-testing)
* Other
    * [Material Components For Android](https://mvnrepository.com/artifact/com.google.android.material/material)
    * [Timber](https://mvnrepository.com/artifact/com.jakewharton.timber/timber)
    * [Android App Startup Runtime](https://mvnrepository.com/artifact/androidx.startup/startup-runtime)
    * [Dokka](https://github.com/Kotlin/dokka)
    * [Kotlin multiplatform serialization](https://github.com/Kotlin/kotlinx.serialization)
    * [Custom Tabs]( https://developer.chrome.com/docs/android/custom-tabs/overview/)
    * [Kotlinx DateTime](https://github.com/Kotlin/kotlinx-datetime)
    * [Paging](https://developer.android.com/jetpack/androidx/releases/paging)
    * [Core Kotlin Extensions](https://developer.android.com/kotlin/ktx#core)
