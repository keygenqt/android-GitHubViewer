buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${findProperty("gradle_version")}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${findProperty("kotlin_version")}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${findProperty("hilt_version")}")
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:${findProperty("dokka_version")}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}