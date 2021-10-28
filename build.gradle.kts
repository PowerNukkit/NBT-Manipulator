import java.nio.file.Files
import java.nio.file.StandardCopyOption

plugins {
    java
    id("org.jetbrains.kotlin.jvm") version "1.5.31"
    maven
    signing
    id("org.jetbrains.dokka") version "1.5.30"
    id("org.ajoberstar.git-publish") version "3.0.0"
}
val kotlinVersion = "1.5.31"
val ossrhUsername: String by project
val ossrhPassword: String by project

group = "br.com.gamemods"
version = "3.1.0-SNAPSHOT"
base {
    archivesBaseName = name
}

sourceSets.main {
    java {
        srcDirs("src/main/kotlin")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = sourceCompatibility
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    jar {
        manifest {
            attributes["Automatic-Module-Name"] = "br.com.gamemods.nbtmanipulator"
        }
    }

    "uploadArchives"(Upload::class) {
        repositories {
            withConvention(MavenRepositoryHandlerConvention::class) {
                mavenDeployer {
                    if (findProperty("signing.secretKeyRingFile") != "undefined") {
                        beforeDeployment {
                            @Suppress("DEPRECATION")
                            signing.signPom(this)
                        }
                    }
                    withGroovyBuilder {
                        "repository"("url" to uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")) {
                            "authentication"("userName" to ossrhUsername, "password" to ossrhPassword)
                        }
                        "snapshotRepository"("url" to uri("https://oss.sonatype.org/content/repositories/snapshots/")) {
                            "authentication"("userName" to ossrhUsername, "password" to ossrhPassword)
                        }
                    }

                    pom.project {
                        withGroovyBuilder {
                            "packaging"("jar")
                            "groupId"(project.group)
                            "artifactId"(project.name)
                            "version"(project.version)
                            "name"(project.name)
                            "description"("A kotlin/java lib that allows you to read and write NBT data in a clean way")
                            "url"("https://github.com/PowerNukkit/NBT-Manipulator")
                            "inceptionYear"("2020")
                            "licenses" {
                                "license" {
                                    "name"("MIT")
                                    "url"("https://raw.githubusercontent.com/PowerNukkit/NBT-Manipulator/master/LICENSE")
                                    "distribution"("repo")
                                }
                            }
                            "developers" {
                                "developer" {
                                    "id"("joserobjr")
                                    "name"("José Roberto de Araújo Júnior")
                                    "email"("joserobjr@powernukkit.org")
                                }
                            }
                            "scm" {
                                "connection"("https://github.com/PowerNukkit/NBT-Manipulator.git")
                                "developerConnection"("https://github.com/PowerNukkit/NBT-Manipulator.git")
                                "url"("https://github.com/PowerNukkit/NBT-Manipulator")
                            }
                        }
                    }
                }
            }
        }
    }
}

tasks.dokkaJavadoc.configure {
    outputDirectory.set(File(buildDir, "javadoc"))
}

tasks.dokkaGfm.configure {
    outputDirectory.set(File(buildDir, "kdoc"))
}

val createReadmeFiles: Task by tasks.creating {
    dependsOn(tasks.dokkaGfm)
    doFirst {
        Files.copy(projectDir.toPath().resolve("README.md"), tasks.dokkaGfm.get().outputDirectory.get().toPath().resolve("nbt-manipulator/index.md"), StandardCopyOption.REPLACE_EXISTING)
    }
}

val createIndexMd = tasks.create<Copy>("createIndexMd") {
    from(File(projectDir, "README.md"))
    into(File(buildDir, "pages"))
    rename("README.md", "index.md")
}

val javadocJar = tasks.create<Jar>("javadocJar") {
    dependsOn(tasks.dokkaJavadoc)
    archiveClassifier.set("javadoc")
    from(tasks.dokkaJavadoc.get().outputDirectory)
    from(File(projectDir, "LICENSE"))
    from(File(projectDir, "README.md"))
    from(File(projectDir, "CHANGELOG.md"))
}

val sourcesJar = tasks.create<Jar>("sourcesJar") {
    from(sourceSets.main.get().java.srcDirs)
    from(File(projectDir, "build.gradle"))
    from(File(projectDir, "gradle.properties"))
    from(File(projectDir, "settings.gradle.kts"))
    from(File(projectDir, "LICENSE"))
    from(File(projectDir, "README.md"))
    from(File(projectDir, "CHANGELOG.md"))
    archiveClassifier.set("sources")
}

tasks.jar {
    from(File(projectDir, "LICENSE"))
    from(File(projectDir, "README.md"))
    from(File(projectDir, "CHANGELOG.md"))
}

artifacts {
    archives(sourcesJar)
    archives(javadocJar)
}

if (findProperty("signing.secretKeyRingFile") != "undefined") {
    signing {
        sign(configurations.archives.get())
    }
}

if (ext.has("org.ajoberstar.grgit.auth.username")) {
    System.setProperty("org.ajoberstar.grgit.auth.username", ext["org.ajoberstar.grgit.auth.username"].toString())
    System.setProperty("org.ajoberstar.grgit.auth.password", ext["org.ajoberstar.grgit.auth.password"].toString())
}

gitPublish {
    // where to publish to (repo must exist)
    repoUri.set("https://github.com/PowerNukkit/NBT-Manipulator.git")

    // where to fetch from prior to fetching from the remote (i.e. a local repo to save time)
    //referenceRepoUri = file("$projectDir/gh-pages").toURI().toString()

    // branch will be created if it doesn't exist
    branch.set("gh-pages")

    // generally, you don't need to touch this
    repoDir.set(File(buildDir, "gh-pages-repo")) // defaults to $buildDir/gitPublish

    // what to publish, this is a standard CopySpec
    contents {
        from(File(buildDir, "javadoc")) {
            into("javadoc")
        }
        from(File(buildDir, "kdoc").resolve("nbt-manipulator")) {
            into("kdoc")
        }
        from(File(buildDir, "pages"))
        from(File("src", "pages"))
        from("README.md")
        from("CHANGELOG.md")
    }

    // what to keep in the existing branch (include=keep)
    preserve {
        include("1.0.0/**")
        exclude("1.0.0/temp.txt")
    }

    // message used when committing changes
    commitMessage.set("Github Pages update") // defaults to 'Generated by gradle-git-publish'
}

tasks {
    gitPublishCopy {
        dependsOn(dokkaJavadoc)
        dependsOn(createReadmeFiles)
        dependsOn(createIndexMd)
    }
}
