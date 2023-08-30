plugins {
    `java-library`
    `maven-publish`
    id("xyz.jpenilla.toothpick")
}

toothpick {
    forkName = "Purpur"
    groupId = "net.pl3x.purpur"
    forkUrl = "https://github.com/pl3xgaming/Purpur"
    val versionTag = System.getenv("BUILD_NUMBER")
        ?: "\"${commitHash() ?: error("Could not obtain git hash")}\""
    forkVersion = "git-$forkName-$versionTag"

    minecraftVersion = "1.16.5"
    nmsPackage = "1_16_R3"
    nmsRevision = "R0.1-SNAPSHOT"

    upstream = "Paper"
    upstreamBranch = "origin/master"

    server {
        project = projects.purpurServer.dependencyProject
        patchesDir = rootProject.projectDir.resolve("patches/server")
    }
    api {
        project = projects.purpurApi.dependencyProject
        patchesDir = rootProject.projectDir.resolve("patches/api")
    }
}

subprojects {
	apply(plugin = "java")
	apply(plugin = "java-library")

    repositories {
        maven("https://nexus.velocitypowered.com/repository/velocity-artifacts-snapshots/")
        maven("https://oss.sonatype.org/content/repositories/snapshots/") {
            name = "sonatype-oss-snapshots"
        }
        maven("https://codeberg.org/Kamillaova/maven-repo/media/branch/main/")
    }

    java {
        sourceCompatibility = JavaVersion.toVersion(17)
        targetCompatibility = JavaVersion.toVersion(17)
    }

    dependencies {
        testImplementation("junit:junit:4.13.1")
        testImplementation("org.hamcrest:hamcrest-library:1.3")
    }
}
