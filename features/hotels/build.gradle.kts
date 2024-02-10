plugins {
    id(Plugins.library)
    id(Plugins.jetBrainsKotlin)
    id(Plugins.kotlinKapt)
    id(Plugins.hilt)
    id(Plugins.googleFirebase)
}

android {
    namespace = "com.islamzada.hotels"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
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

    implementation(project(":entities"))
    implementation(project(":common"))
    implementation(project(":domain"))

    implementation(Libs.NAV.navigationUi)
    implementation(Libs.NAV.navigationFragment)
    implementation(Libs.HILT.hilt)
    kapt(Libs.HILT.hiltKapt)

    implementation(Libs.UI.material)
    implementation(Libs.UI.core)
    implementation(Libs.UI.combat)

    implementation(platform(Libs.GoogleService.firebaseBom))
    implementation(Libs.GoogleService.firebaseAuth)
    implementation(Libs.GoogleService.playService)
    implementation(Libs.GoogleService.firebaseStore)

    implementation(Libs.GLIDE.glide)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}