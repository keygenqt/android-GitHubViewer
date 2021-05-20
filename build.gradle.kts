buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots") {
            content {
                includeModule("com.google.dagger", "hilt-android-gradle-plugin")
            }
        }
    }

    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:HEAD-SNAPSHOT")
        classpath("com.android.tools.build:gradle:${findProperty("gradle_version")}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${findProperty("kotlin_version")}")
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