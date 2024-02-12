plugins {
    id(Plugins.library)
    id(Plugins.jetBrainsKotlin)
    id(Plugins.hilt)
    id(Plugins.kotlinKapt)
    id(Plugins.googleFirebase)
    id(Plugins.safeArgs)

}

android {
    namespace = "com.islamzada.login"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        viewBinding = true
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

    implementation ("com.airbnb.android:lottie:6.3.0")

    implementation(project(":common"))
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

    implementation(platform(Libs.GoogleService.firebaseBom))
    implementation(Libs.GoogleService.firebaseAuth)
    implementation(Libs.GoogleService.playService)


    implementation("com.facebook.android:facebook-login:latest.release")
    implementation("com.facebook.android:facebook-android-sdk:15.1.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}