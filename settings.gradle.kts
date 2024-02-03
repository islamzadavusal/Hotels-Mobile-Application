pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Hotels Application"
include(":app")
include(":entities")
include(":data")
include(":common")
include(":domain")
include(":network")
include(":features:hotels")
include(":features:favorite")
