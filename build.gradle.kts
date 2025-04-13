// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.dagger.hilt.android") version ("2.56") apply false
    id("com.google.devtools.ksp") version "2.1.20-1.0.32" apply false
    id ("org.sonarqube") version "3.5.0.2730"
}

buildscript {
    dependencies {
        classpath ("org.jacoco:org.jacoco.core:0.8.12") // Use the latest version
        classpath( "org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:3.5.0.2730")

    }
    repositories {
        google()
    }
}