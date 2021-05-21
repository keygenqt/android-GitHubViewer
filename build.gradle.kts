buildscript {

    val kotlinVersion = "1.4.32"
    val dokkaVersion = "1.4.32"
    val gradleVersion = "7.1.0-alpha01"

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
        classpath("com.android.tools.build:gradle:$gradleVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:$dokkaVersion")
        classpath(kotlin("gradle-plugin", version = kotlinVersion))
        classpath(kotlin("serialization", version = kotlinVersion))

        classpath("com.google.dagger:hilt-android-gradle-plugin:HEAD-SNAPSHOT")
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