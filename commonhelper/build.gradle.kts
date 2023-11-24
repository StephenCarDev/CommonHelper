import java.util.Date
import java.text.SimpleDateFormat

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.stephen.commonhelper"
    compileSdk = 34

    defaultConfig {
        minSdk = 30

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    val appName = "CommonHelper"
    val buildTime = SimpleDateFormat("yyyyMMdd").format(Date())
    val versionName = "1.0.$buildTime"
    android.libraryVariants.configureEach {
        val buildType = this.buildType.name
        outputs.all {
            if (this is com.android.build.gradle.internal.api.LibraryVariantOutputImpl) {
                this.outputFileName = "${appName}_${versionName}_${buildType}.apk"
            }
        }
    }
}

dependencies {

    implementation(fileTree("libs").include("*.aar", "*.jar"))
    // retrofit
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

    // mqtt
    implementation ("org.eclipse.paho:org.eclipse.paho.client.mqttv3:1.2.5")

    implementation("com.google.code.gson:gson:2.10")
    implementation("com.google.protobuf:protobuf-java:3.19.4")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")

    // 键值对存储，三选一
    implementation("com.tencent:mmkv:1.3.2")
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    // 协程 Coroutine
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}