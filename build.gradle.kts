buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin")
    }
}

plugins {
    kotlin("jvm") version "1.7.10"

    id("java-gradle-plugin")
    id("com.vanniktech.maven.publish") version "0.21.0"
    id("io.gitlab.arturbosch.detekt") version "1.21.0"
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
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
    api(platform("org.jetbrains.kotlin:kotlin-bom:1.7.10"))

    // dependencies for this plugin itself

    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")

    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")

    // dependencies for plugins that are going to be applied to the project that uses this plugin

    implementation("com.vanniktech:gradle-maven-publish-plugin:0.22.0")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.21.0")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:1.7.10")
    implementation("org.jlleitschuh.gradle:ktlint-gradle:11.0.0")
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

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}
