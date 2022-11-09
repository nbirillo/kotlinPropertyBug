plugins {
    java
    id("org.jetbrains.kotlin.jvm") version "1.6.10" apply false
    id("org.jetbrains.kotlin.multiplatform") version "1.6.10" apply false
    application
}

allprojects {
    repositories {
        mavenCentral()
    }
}