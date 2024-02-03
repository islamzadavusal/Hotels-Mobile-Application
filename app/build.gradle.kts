plugins {
    id(Plugins.androidApplication)
    id(Plugins.jetBrainsKotlin)
    id(Plugins.hilt)
    id(Plugins.kotlinKapt)
}

android {
    namespace = "com.islamzada.hotelsapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.islamzada.hotelsapplication"
        minSdk = 24
        targetSdk = 34
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

    implementation(Libs.UI.material)
    implementation(Libs.NAV.navigationUi)
    implementation(Libs.NAV.navigationFragment)
    implementation(Libs.HILT.hilt)
    kapt(Libs.HILT.hiltKapt)

    implementation(Libs.UI.material)
    implementation(Libs.UI.core)
    implementation(Libs.UI.combat)
    implementation(Libs.UI.constraintlayout)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}