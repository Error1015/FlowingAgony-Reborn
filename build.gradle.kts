import java.text.SimpleDateFormat
import java.util.*
import kotlin.reflect.KProperty

plugins {
    id("net.minecraftforge.gradle")
    id("org.parchmentmc.librarian.forgegradle")
    kotlin("jvm")
    kotlin("plugin.serialization")
    idea
    `maven-publish`
    id("me.modmuss50.mod-publish-plugin")
}

val minecraft_version: String by project
val minecraft_version_range: String by project
val forge_version: String by project
val forge_version_range: String by project
val loader_version_range: String by project
val mod_id: String by project
val mod_name: String by project
val mod_version: String by project
val mod_authors: String by project
val mod_license: String by project
val mod_description: String by project
val mod_group_id: String by project
val mapping_channel: String by project
val mapping_version: String by project
val kff_version: String by project

group = mod_group_id
version = mod_version

base.archivesName = mod_name

version = mod_version
group = mod_group_id

base {
    archivesName = "$mod_name-$minecraft_version"
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(17)
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

publishMods {
    val kffSlug = "kotlin-for-forge"

    file.set(tasks.jar.get().archiveFile)
    type.set(STABLE)
    modLoaders.add("forge")
    changelog = """
       ## No More.
    """.trimIndent()
    version.set(mod_version)
    displayName = base.archivesName

    curseforge {
        projectId = "1218577"
        projectSlug = "marblegates-exotic-enchantment-reborn"
        accessToken = System.getenv("CF_TOKEN")
        minecraftVersions.add(minecraft_version)
        requires(kffSlug)
    }

    modrinth {
        projectId = "nTa4l6xw"
        accessToken = System.getenv("MODRINTH_TOKEN")
        minecraftVersions.add(minecraft_version)
        requires(kffSlug)
    }

    github {
        repository.set("Error1015/FlowingAgony-Reborn")
        accessToken = System.getenv("GITHUB_TOKEN")
        commitish = "1.20.1"
    }
}

println(Platform)

object Platform {
    val java: String = System.getProperty("java.version")
    val jvm: String = System.getProperty("java.vm.version")
    val vendor: String = System.getProperty("java.vendor")
    val arch: String = System.getProperty("os.arch")

    override fun toString() = """
        Java : $java,
        Jvm  : $jvm ,
        Vendor: $vendor,
        Arch : $arch
    """.trimIndent()
}

minecraft {
    mappings(mapping_channel, mapping_version)
    copyIdeResources = true
    // accessTransformer = file("src/main/resources/META-INF/accesstransformer.cfg")

    runs {
        configureEach {
            source(sourceSets.main.get())

            property("mixin.env.remapRefMap", "true")
            property("mixin.env.refMapRemappingFile", "$projectDir/build/createSrgToMcp/output.srg")
            property("forge.logging.console.level", "debug")
        }

        create("client") {
            workingDirectory(file("run"))
            properties(
                mapOf(
                    "forge.logging.markers" to "REGISTRIES", "forge.logging.console.level" to "debug"
                )
            )
        }

        create("server") {
            workingDirectory(file("run/server"))
            args("--nogui")
            property("neoforge.enabledGameTestNamespaces", mod_id)
        }

        create("gameTestServer") {
            workingDirectory(file("run/server"))
            property("neoforge.enabledGameTestNamespaces", mod_id)
        }

        create("data") {
            workingDirectory(file("run"))
            args("--mod", mod_id, "--all", "--output", file("src/generated/resources/").absolutePath, "--existing", file("src/main/resources/").absolutePath)
        }
    }
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
    compilerOptions {
        freeCompilerArgs.add("-Xwhen-guards")
    }
}

sourceSets.main.get().resources.srcDir("src/generated/resources")

repositories {
    mavenLocal()
    mavenCentral()
    maven(url = "https://thedarkcolour.github.io/KotlinForForge/") {
        name = "Kotlin For Forge Maven"
        content {
            includeGroup("thedarkcolour")
        }
    }

    maven(url = "https://www.cursemaven.com") {
        content {
            includeGroup("curse.maven")
        }
    }
}

dependencies {
    minecraft("net.minecraftforge:forge:$minecraft_version-$forge_version")
    implementation("thedarkcolour:kotlinforforge:$kff_version")

    runtimeOnly(fg.deobf("curse.maven:bookshelf-228525:5423987"))
    runtimeOnly(fg.deobf("curse.maven:enchantment-descriptions-250419:5855251"))
    runtimeOnly(fg.deobf("curse.maven:jade-324717:6106101"))
    runtimeOnly(fg.deobf("curse.maven:jei-238222:6075247"))
}

tasks.withType<ProcessResources>().configureEach {
    val replaceProperties = mapOf(
        "minecraft_version" to minecraft_version, "minecraft_version_range" to minecraft_version_range, "forge_version" to forge_version, "forge_version_range" to forge_version_range,
        "loader_version_range" to loader_version_range, "mod_id" to mod_id, "mod_name" to mod_name, "mod_license" to mod_license, "mod_version" to mod_version, "mod_authors" to mod_authors,
        "mod_description" to mod_description
    )
    inputs.properties(replaceProperties)

    filesMatching(listOf("META-INF/mods.toml", "pack.mcmeta")) {
        expand(replaceProperties)
    }
}


tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.release.set(17)
}

publishing {
    publications {}

    repositories {
        mavenLocal()
    }
}


tasks.named<Jar>("jar") {
    manifest {
        attributes(
            mapOf(
                "Specification-Title" to mod_id, "Specification-Vendor" to mod_authors, "Specification-Version" to "1", "Implementation-Title" to project.name,
                "Implementation-Version" to archiveVersion.get(), "Implementation-Vendor" to mod_authors,
                "Implementation-Timestamp" to SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ROOT).format(Date())
            )
        )
    }
    finalizedBy("reobfJar")
}

idea {
    module.isDownloadJavadoc = true
    module.isDownloadSources = true
}