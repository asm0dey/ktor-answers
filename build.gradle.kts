import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

plugins {
    alias(libs.plugins.org.jetbrains.kotlin.jvm)
    alias(libs.plugins.io.ktor.plugin)
    alias(libs.plugins.org.jetbrains.kotlin.plugin.serialization)
    id("nu.studer.jooq") version "8.2"
}

group = "io.ktor.answers"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.ktor.server.core.jvm)
    implementation(libs.ktor.server.content.negotiation.jvm)
    implementation(libs.ktor.serialization.kotlinx.json.jvm)
    implementation(libs.ktor.server.host.common.jvm)
    implementation(libs.ktor.server.status.pages.jvm)
    implementation(libs.ktor.server.netty.jvm)
    implementation(libs.logback.classic)
    implementation(libs.exposed.core)
    implementation(libs.exposed.dao)
    implementation(libs.exposed.jdbc)
    implementation(libs.exposed.kotlin.datetime)
    implementation(libs.liquibase)
    implementation(libs.jooq)
    implementation(libs.jooq.kotlin)
    implementation(libs.jooq.kotlin.coroutines)
    runtimeOnly(libs.postgres)
    jooqGenerator(libs.postgres)
    testImplementation(kotlin("test"))
    testImplementation(libs.ktor.server.tests.jvm)
    testImplementation(libs.testcontainers.postgres)
    testImplementation(libs.testcontainers.jupiter)
    testImplementation(libs.kotlinx.coroutines.test)
}

tasks.test {
    useJUnitPlatform()
}

sourceSets {
    create("jooq") {
        kotlin.srcDir("src/main/jooq")
    }
}

jooq {
    configurations {
        create("main") {
            jooqConfiguration.apply {
                jdbc.apply {
                    driver = "org.postgresql.Driver"
                    url = System.getenv("DB_URL") ?: "jdbc:postgresql://localhost:5432/postgres"
                    user = System.getenv("DB_USER") ?: "postgres"
                    password = System.getenv("DB_PASSWORD") ?: "password"
                }
                generator.apply {
                    database.apply {
                        inputSchema = "public"
                        includes = ".*"
                        excludes = "database.*"
                    }
                    target.apply {
                        packageName = "io.ktor.answers.generated"
                        directory = "src/main/jooq"
                    }
                }
            }
        }
    }
}

kotlin {
    jvmToolchain {
        this.languageVersion.set(JavaLanguageVersion.of(17))
    }
}