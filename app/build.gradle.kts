@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt.gradle)
    alias(libs.plugins.ksp)
    alias(libs.plugins.android.gms)
    alias(libs.plugins.firebase.crashlytics)
}

android {
    namespace = "io.minoro75.hsrhelper"
    compileSdk = 33

    defaultConfig {
        applicationId = "io.minoro75.hsrhelper"
        minSdk = 27
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Core libs
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.core.lifecycle.viewmodel.compose)
    implementation(libs.androidx.core.lifecycle.runtime.ktx)
    implementation(libs.androidx.core.lifecycle.runtime.compose)
    implementation(libs.androidx.core.datastore)
    implementation(libs.androidx.core.lifecycle.process)
    implementation(libs.androidx.core.appupdate)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.fcm)

    // Dagger-Hilt DI
    kapt(libs.hilt.compiler) //ToDo: replace with ksp() asap after release
    implementation(libs.hilt.android)
    implementation(libs.hilt.composenav)

    // Room DB
    ksp(libs.room.compiler)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)

    // Retrofit - Network calls
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.moshi)
    implementation(libs.retrofit.okhttp)

    // Moshi - JSON serialization
    ksp(libs.moshi.core)
    implementation(libs.moshi.kotlin)

    // DataStore
    implementation(libs.datastore.core)

    // Accompanist utils
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicator)
    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.accompanist.navanimations)
    implementation(libs.accompanist.permissions)

    // Core Compose libs
    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.compose.activity)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.material3)

    //Image Loading
    implementation(libs.coil.compose)
    
    // Testing etc
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}