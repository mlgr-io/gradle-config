plugins {
    `kotlin-dsl`
}

repositories {
    mavenLocal()
    google()
    gradlePluginPortal()
    mavenCentral()
}

tasks {
    val sourcesJar by creating(Jar::class) {
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
    }

    artifacts {
        archives(sourcesJar)
    }
}
