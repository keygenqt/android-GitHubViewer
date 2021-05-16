plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

// To make it available as direct dependency
group = "com.keygenqt.internal"
version = "SNAPSHOT"

repositories {
    jcenter()
}

gradlePlugin {
    plugins.register("internal") {
        id = "internal"
        implementationClass = "com.keygenqt.internal.InternalPlugin"
    }
}
