// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.androidApplication) version Versions.androidApplication apply false
    id(Plugins.jetBrainsKotlin) version Versions.jetbrainsKotlinAndroid apply false
    id(Plugins.library) version Versions.library apply false
    id(Plugins.safeArgs) version Versions.safeArgs apply false
    id(Classpath.hilt) version Versions.hilt apply false
}