package io.mailguru.gradle.config

import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Test

internal class ConfigPluginTest {

    @Test
    fun `apply the plugin`() {
        ProjectBuilder.builder().build().also { project ->
            project.pluginManager.apply("io.mailguru.gradle-config")
            project.plugins.getPlugin(ConfigPlugin::class.java)
        }
    }
}
