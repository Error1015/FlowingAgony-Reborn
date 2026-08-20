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
        kotlin("jvm") version "2.1.20"
        kotlin("plugin.serialization") version "2.1.20"
        id("org.parchmentmc.librarian.forgegradle") version "1.+"
        id("me.modmuss50.mod-publish-plugin") version "0.8.4"
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.10.0"
}

rootProject.name = "FlowingAgony-forge-1.20.1"