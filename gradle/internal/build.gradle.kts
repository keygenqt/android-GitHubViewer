plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

group = "com.keygenqt.internal"
version = "0.0.1"

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins.register("internal") {
        id = "internal"
        implementationClass = "com.keygenqt.internal.InternalPlugin"
    }
}
