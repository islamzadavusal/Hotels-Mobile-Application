plugins {
    id(Plugins.androidApplication)
    id(Plugins.jetBrainsKotlin)
    id(Plugins.hilt)
    id(Plugins.kotlinKapt)
    id(Plugins.googleFirebase)
}

android {
    namespace = "com.islamzada.hotelsapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.islamzada.hotelsapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.5"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    signingConfigs {
        create("release") {
            keyAlias = "key0"
            keyPassword = "Qweasd"
            storeFile = file("../certificates/Release")
            storePassword = "Qweasd"
        }

        create("dev") {
            keyAlias = "key0"
            keyPassword = "Qweasd"
            storeFile = file("../certificates/Debug")
            storePassword = "Qweasd"
        }
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
        }

        debug {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("dev")
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":features:hotels"))
    implementation(project(":features:login"))
    implementation(project(":features:splashScreen"))
    implementation(project(":features:favorite"))
    implementation(project(":features:account"))

    implementation(project(":common"))

    implementation(Libs.UI.material)
    implementation(Libs.NAV.navigationUi)
    implementation(Libs.NAV.navigationFragment)
    implementation(Libs.HILT.hilt)
    kapt(Libs.HILT.hiltKapt)

    implementation(Libs.UI.material)
    implementation(Libs.UI.core)
    implementation(Libs.UI.combat)
    implementation(Libs.UI.constraintlayout)

    implementation(platform(Libs.GoogleService.firebaseBom))
    implementation(Libs.GoogleService.firebaseAuth)
    implementation(Libs.GoogleService.playService)

    implementation ("com.airbnb.android:lottie:6.3.0")

    implementation("com.facebook.android:facebook-login:latest.release")
    implementation("com.facebook.android:facebook-android-sdk:15.1.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}