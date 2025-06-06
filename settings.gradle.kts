pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        maven("https://maven.neoforged.net/releases")
    }

    plugins {
        kotlin("jvm") version "2.1.10"
        kotlin("plugin.serialization") version "2.1.10"
        id("net.neoforged.moddev") version "2.0.88"
    }
}