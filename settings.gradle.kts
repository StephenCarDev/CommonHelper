pluginManagement {
    repositories {
        maven("https://maven.aliyun.com/repository/google")
        maven ("https://maven.aliyun.com/repository/public")
        maven ("https://maven.aliyun.com/repository/gradle-plugin")
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven ("https://maven.aliyun.com/repository/google")
        maven ("https://maven.aliyun.com/repository/public")
        maven ("https://jitpack.io")
        google()
        mavenCentral()
    }
}

rootProject.name = "CommonHelper"
include(":app")
include(":commonhelper")
