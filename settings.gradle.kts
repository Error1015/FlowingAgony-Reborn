pluginManagement {
    repositories {
        gradlePluginPortal()
        maven(
            url = "https://maven.minecraftforge.net/"
        ) {
            name = "MinecraftForge"
        }
        maven(
            url = "https://maven.parchmentmc.org"
        ) {
            name = "parchmentmc"
        }
    }

    plugins {
        kotlin("jvm") version "2.1.10"
        kotlin("plugin.serialization") version "2.1.10"
        id("net.minecraftforge.gradle") version "[6.0.16,6.2)"
        id("org.parchmentmc.librarian.forgegradle") version "1.+"
        id("me.modmuss50.mod-publish-plugin") version "0.8.4"
    }
}

rootProject.name = "FlowingAgony-forge-1.20.1"