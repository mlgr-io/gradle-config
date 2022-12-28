import com.vanniktech.maven.publish.SonatypeHost

buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin")
    }
}

plugins {
    kotlin("jvm") version 1.8.0

    id("java-gradle-plugin")
    id("com.vanniktech.maven.publish") version Versions.mavenPublish
    id("io.gitlab.arturbosch.detekt") version Versions.detekt
    id("org.jlleitschuh.gradle.ktlint") version Versions.ktlint
}

repositories {
    mavenLocal()
    google()
    gradlePluginPortal()
    mavenCentral()
}

base {
    group = "io.mailguru"
    archivesName.set("gradle-config")
}

dependencies {
    api(platform("org.jetbrains.kotlin:kotlin-bom:" + Versions.kotlin))

    // Import versions declaration from buildSrc/src/main/kotlin/Versions.kt

    compileOnly(files("buildSrc/build/libs/buildSrc.jar"))

    // Dependencies for this plugin itself

    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")

    testImplementation("org.junit.jupiter:junit-jupiter:" + Versions.junitJupiter)

    // Dependencies for plugins that are going to be applied to the project that uses this plugin

    implementation("com.vanniktech:gradle-maven-publish-plugin:" + Versions.mavenPublish)
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:" + Versions.detekt)
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:" + Versions.dokka)
    implementation("org.jlleitschuh.gradle:ktlint-gradle:" + Versions.ktlint)
}

gradlePlugin {
    plugins {
        create("gradle-config") {
            id = "io.mailguru.gradle-config"
            implementationClass = "io.mailguru.gradle.config.ConfigPlugin"
        }
    }
}

detekt {
    allRules = true
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.S01)
    signAllPublications()
    pom {
        url.set("https://github.com/mlgr-io/gradle-config")
        licenses {
            license {
                name.set("GNU General Public License, Version 3")
                url.set("https://www.gnu.org/licenses/gpl-3.0.txt")
            }
        }
        developers {
            developer {
                name.set("Sascha Weyers")
                email.set("sw@mailguru.io")
                organization.set("mailguru UG (haftungsbeschränkt)")
                organizationUrl.set("https://mailguru.io")
            }
        }
        scm {
            connection.set("scm:git:git://github.com/mlgr-io/gradle-config.git")
            developerConnection.set("scm:git:ssh://github.com:mlgr-io/gradle-config.git")
            url.set("https://github.com/mlgr-io/gradle-config")
        }
    }
    repositories {
        maven {
            url = if (version.toString().endsWith("SNAPSHOT")) {
                uri(layout.buildDirectory.dir("repos/snapshots"))
            } else {
                uri(layout.buildDirectory.dir("repos/releases"))
            }
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}
