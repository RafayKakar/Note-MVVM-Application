plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.dagger.hilt.android")
    id("jacoco")
    id("com.google.devtools.ksp") // Apply the KSP plugin here
    id("org.sonarqube") // Apply the KSP plugin here
}

android {
    namespace = "com.example.mynotesapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.mynotesapplication"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
           isTestCoverageEnabled=true
        }
    }

    testOptions {
        animationsDisabled =true
        unitTests.isReturnDefaultValues = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
        buildConfig = true
    }

    tasks.register<JacocoReport>("jacocoTestReport") {
        dependsOn("testDebugUnitTest", "createDebugCoverageReport")

        val fileFilter = listOf(
            "**/R.class",
            "**/R$*.class",
            "**/BuildConfig.*",
            "**/Manifest*.*",
            "**/*Test*.*",
            "android/**/*.*"
        )

        val debugTree = fileTree(
            mapOf(
                "dir" to "$buildDir/intermediates/classes/debug",
                "excludes" to fileFilter
            )
        )

        val mainSrc = "$projectDir/src/main/java"

        sourceDirectories.setFrom(files(mainSrc))
        classDirectories.setFrom(files(debugTree))

        executionData.setFrom(fileTree(buildDir).apply {
            include(
                "jacoco/testDebugUnitTest.exec",
                "outputs/code-coverage/connected/*coverage.ec"
            )
        })

        reports {
            html.required.set(true)
            xml.required.set(true)
            csv.required.set(false)
        }
    }

    sonarqube {
        properties {
            property ("sonar.sources", "./src/main")
            property ("sonar.host.url", "https://sonarcloud.io/")
            property ("sonar.projectName", "Note-MVVM-Application")
            property ("sonar.projectKey", "RafayKakar_Note-MVVM-Application")
        }
    }

}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //UI
    implementation("com.google.android.material:material:1.1.0")
    implementation("com.intuit.sdp:sdp-android:1.0.6")
    implementation("androidx.cardview:cardview:1.0.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.56")
    ksp("com.google.dagger:hilt-compiler:2.56")

    //Viewmodel
    var lifecycle_version = "2.4.0"
    implementation("androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.fragment:fragment-ktx:1.3.2")
    implementation("androidx.activity:activity-ktx:1.3.1")

    //Room
    var room_version = "2.4.3"
    implementation("androidx.room:room-runtime:$room_version")
    ksp("androidx.room:room-compiler:$room_version")

    implementation("org.sonarsource.scanner.maven:sonar-maven-plugin:2.7.1")
}