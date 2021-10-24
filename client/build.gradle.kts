val ktor_version: String by project

plugins {
    application
    kotlin("multiplatform") version "1.5.31"
    kotlin("plugin.serialization") version "1.5.31"
}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set("com.example.MainKt")
}

repositories {
    mavenCentral()
}

kotlin {
    sourceSets {
        jvm()
        macosX64 {
            binaries {
                executable {
                    entryPoint = "com.example.main"
                }
            }
        }

        getByName("commonMain") {
            dependencies {
                implementation("io.ktor:ktor-client-core:$ktor_version")
                implementation("io.ktor:ktor-client-serialization:$ktor_version")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2-native-mt")
            }
        }

        getByName("jvmMain") {
            dependencies {
                implementation("io.ktor:ktor-client-java:$ktor_version")
            }
        }

        getByName("macosX64Main") {
            dependencies {
                implementation("io.ktor:ktor-client-curl:$ktor_version")
            }
        }
    }
}



