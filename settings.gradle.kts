pluginManagement {
    repositories {
        gradlePluginPortal()
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/raphael1928/admob-banner-kit")
            credentials {
//              Token com expiração de 7 dias somente para conseguir testar sem precisar pasar o gradle.properties
                username = "raphael1928"
                password = "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"
            }
        }
    }
}

rootProject.name = "AdMobBannerKitConsumer"
include(":app")