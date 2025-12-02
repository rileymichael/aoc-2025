plugins {
    kotlin("jvm") version "2.2.20"
    kotlin("plugin.power-assert") version "2.2.20"
    application
}

group = "com.github.rileymichael.aoc2025"

repositories {
    mavenCentral()
}


dependencies {
    implementation(kotlin("reflect"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.12.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("${group}.AdventKt")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}