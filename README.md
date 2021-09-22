GitHub Viewer
===================

![picture](data/preview.png)

Implementation of the application using the latest Android Tech Stack and the [GitHub REST API](https://docs.github.com/en/rest).

```xml
<!-- Github login. You can change the user to your own-->
<string name="github_user">keygenqt</string>
```

### Architecture

* MVVM - [Guide to app architecture](https://develSwipeRefresh(oper.android.com/jetpack/guide)
* [Kotlin](https://kotlinlang.org/) 100%, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines),
  [Flow](https://kotlinlang.org/docs/flow.html)

### Preview
<p align="center">
<img src="data/vokoscreen-2021-05-27_10-53-31.gif" width="32%"/>
<img src="data/vokoscreen-2021-05-27_10-50-27.gif" width="32%"/>
<img src="data/vokoscreen-2021-06-01_16-25-26.gif" width="32%"/>
</p>

### Libraries

* Accompanist
    * [Accompanist Insets](https://google.github.io/accompanist/insets/)
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
    * [Crypto](https://developer.android.com/jetpack/androidx/releases/security)
* Test
    * [JUnit](https://mvnrepository.com/artifact/junit/junit)
    * [MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver)
    * [Mockito](https://github.com/mockito/mockito)
    * [UI Test Junit4](https://developer.android.com/jetpack/compose/testing#setup)
    * [UI Test Manifest](https://developer.android.com/jetpack/compose/testing#setup)
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

# License

```
Copyright 2021 Vitaliy Zarubin

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```