plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.10.0"
}

group = "com.github.gr3gdev"
version = "1.0-SNAPSHOT"

val gdxVersion = "1.11.0"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation("com.badlogicgames.gdx:gdx:$gdxVersion")
    implementation("com.badlogicgames.gdx:gdx-backend-lwjgl3:$gdxVersion")
    implementation("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-desktop")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("2021.3.3")
}

tasks {
    patchPluginXml {
        version.set("${project.version}")
        sinceBuild.set("219")
        changeNotes.set("""
            Add change notes here.<br>
            <em>most HTML tags may be used</em>        """.trimIndent())
    }
}