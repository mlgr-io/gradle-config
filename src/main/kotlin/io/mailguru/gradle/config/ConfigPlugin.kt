package io.mailguru.gradle.config

import com.vanniktech.maven.publish.MavenPublishPlugin
import io.gitlab.arturbosch.detekt.DetektPlugin
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.DependencyResolutionListener
import org.gradle.api.artifacts.ResolvableDependencies
import org.gradle.api.tasks.testing.Test
import org.jetbrains.dokka.gradle.DokkaPlugin
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.KtlintPlugin
import java.util.Locale

class ConfigPlugin : DependencyResolutionListener, Plugin<Project> {

    var project: Project? = null

    val versionKotlin = "1.7.10"

    val versionJupiter = "5.9.0"
    val versionKotest = "5.4.2"

    override fun apply(project: Project) {
        this.project = project.also {
            it.gradle.addListener(this)
        }

        addPlugins()

        project.tasks.withType(Test::class.java).configureEach {
            it.useJUnitPlatform()
        }
        println("-- Configured tasks.withType<Test>().")

        project.tasks.withType(KotlinCompile::class.java).configureEach {
            it.kotlinOptions.apply {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "11"
            }
        }
        println("-- Configured tasks.withType<KotlinCompile>().")

        // Plugins configuration

        project.extensions.configure(DetektExtension::class.java) {
            it.allRules = true
            println("-- Configured DetektExtension.")
        }
    }

    override fun beforeResolve(dependencies: ResolvableDependencies) {
        addDependencies()
        project?.gradle?.removeListener(this)
    }

    private fun addPlugins() {
        project?.pluginManager?.let { p ->
            p.apply(KotlinPlatformJvmPlugin::class.java)
            println("-- Applied plugin: KotlinPlatformJvmPlugin")

            p.apply(DetektPlugin::class.java)
            println("-- Applied plugin: DetektPlugin")

            p.apply(DokkaPlugin::class.java)
            println("-- Applied plugin: DokkaPlugin")

            p.apply(MavenPublishPlugin::class.java)
            println("-- Applied plugin: MavenPublishPlugin")

            p.apply(KtlintPlugin::class.java)
            println("-- Applied plugin: KtlintPlugin")
        }
    }

    private fun addDependencies() {

        // plugin dependencies are defined in the main build.gradle.kts

        project?.dependencies?.let { dependencyHandler ->
            mapOf(
                "api" to listOf(
                    String.format(Locale.ROOT, "org.jetbrains.kotlin:kotlin-bom:%s", versionKotlin),
                ),
                "testImplementation" to listOf(
                    String.format(Locale.ROOT, "io.kotest:kotest-assertions-core:%s", versionKotest),
                    String.format(Locale.ROOT, "io.kotest:kotest-property:%s", versionKotest),
                    String.format(Locale.ROOT, "io.kotest:kotest-runner-junit5:%s", versionKotest),
                    "org.jetbrains.kotlin:kotlin-test-junit5",
                    String.format(Locale.ROOT, "org.junit.jupiter:junit-jupiter:%s", versionJupiter),
                ),
            ).forEach { entry ->
                entry.value.forEach {
                    println("-- Added dependency: " + entry.key + "(" + it + ")")
                    dependencyHandler.add(entry.key, it)
                }
            }
        }
    }

    override fun afterResolve(dependencies: ResolvableDependencies) = Unit
}
