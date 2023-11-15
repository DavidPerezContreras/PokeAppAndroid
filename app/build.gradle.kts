plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")


}

android {
    namespace = "perez.david.pokeappandroid"
    compileSdk = 34

    defaultConfig {
        applicationId = "perez.david.pokeappandroid"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        //testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunner = "perez.david.pokeappandroid.CustomTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        viewBinding=true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    // Allow references to generated code
    kapt {
        correctErrorTypes = true
    }

}

dependencies {




    // For instrumentation tests
    //androidTestImplementation("com.google.dagger:hilt-android-testing:2.48.1")
    //kaptAndroidTest("com.google.dagger:hilt-compiler:2.48.1")

    // For local unit tests
    //testImplementation("com.google.dagger:hilt-android-testing:2.48.1")
    //kaptTest("com.google.dagger:hilt-compiler:2.48.1")




// Hilt ViewModel extensions (if you're using ViewModels) with Kotlin-friendly imports
    //implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    //kapt("androidx.hilt:hilt-compiler:1.1.0-beta01")

    // OkHttp for HTTP requests
    implementation ("com.squareup.okhttp3:okhttp:4.11.0")

    // Retrofit for API communication
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")


    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.5")


    implementation("androidx.room:room-runtime:2.6.0")
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    implementation("androidx.test:runner:1.5.2")
    kapt("androidx.room:room-compiler:2.6.0")

    //implementation("io.coil-kt:coil-compose:2.4.0")





    //implementation("com.jakewharton.timber:timber:4.7.1")

    //implementation("androidx.hilt:hilt-navigation-compose")




    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-service:2.6.2")
    //implementation(project(mapOf("path" to ":domain")))
    //implementation(project(mapOf("path" to ":model")))
    //implementation("io.insert-koin:koin-android:3.4.3")
    //implementation("io.insert-koin:koin-core:3.4.3")
    //implementation("io.insert-koin:koin-androidx-compose:3.4.0")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation("androidx.paging:paging-runtime-ktx:3.2.1")
    implementation("androidx.paging:paging-compose:3.2.1")
    implementation("androidx.navigation:navigation-compose:2.7.4")

    implementation ("io.coil-kt:coil-compose:2.4.0") // Coil Core
    implementation ("io.coil-kt:coil-gif:2.4.0") // Support for Gif presentation implementation "io.coil-kt:coil-svg:2.4.0" // Support for SVG
    implementation ("io.coil-kt:coil-video:2.4.0") // Support for video frame presentation

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("androidx.appcompat:appcompat:1.6.1")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")


    //implementation("androidx.paging:paging-runtime-ktx:3.2.1")



    // For instrumented tests.
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.48.1")
    // ...with Kotlin.
    implementation ("com.google.dagger:hilt-android:2.48.1")
    kapt ("com.google.dagger:hilt-compiler:2.48.1")


// Local Unit Tests
    /*implementation( "androidx.test:core:1.5.0")
    testImplementation ( "junit:junit:4.13.2")
    testImplementation ( "org.hamcrest:hamcrest-all:1.3")
    testImplementation ( "androidx.arch.core:core-testing:2.2.0")
    testImplementation ( "org.robolectric:robolectric:4.3.1")
    testImplementation ( "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
    testImplementation ( "com.google.truth:truth:1.0.1")
    testImplementation ( "org.mockito:mockito-core:5.3.1")

    // Instrumented Unit Tests
    androidTestImplementation ( "junit:junit:4.13.2")
    //androidTestImplementation ( "com.linkedin.dexmaker:dexmaker-mockito:2.12.1")
    androidTestImplementation ( "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
    androidTestImplementation ( "androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation ( "com.google.truth:truth:1.0.1")
    androidTestImplementation ( "androidx.test.ext:junit:1.1.5")
    androidTestImplementation ( "androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation ( "org.mockito:mockito-core:5.3.1")
    androidTestImplementation ( "com.google.dagger:hilt-android-testing:2.48.1")
    kaptAndroidTest ( "com.google.dagger:hilt-android-compiler:2.44")
*/
}


