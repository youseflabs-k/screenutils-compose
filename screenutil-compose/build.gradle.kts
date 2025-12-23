plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
    alias(libs.plugins.jreleaser)
    alias(libs.plugins.kotlin.compose)
}
jreleaser {
    // IMPORTANT: always use the root config file
    configFile.set(rootProject.file("jreleaser.yml"))

    // optional but helpful
    gitRootSearch.set(true)
}
group = "io.github.youseflabs-k"
version = "0.1.1"

android {
    namespace = "io.github.youseflabs.screenutil"
    compileSdk = 36

    defaultConfig {
        minSdk = 23
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    // Compose (needed for previews + Compose-based API)
    buildFeatures {
        compose = true
    }

    // Use the compiler extension version that matches your Compose BOM setup
    // If you're on the new Compose compiler plugin, remove this block.

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
            // withJavadocJar() // optional; only if you generate javadocs/dokka
        }
    }
}

dependencies {
    // --- Compose ---
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.ui.tooling.preview)

    // Optional (if you want Material3 demo previews inside the library)
    implementation(libs.androidx.compose.material3)

    // Debug-only tooling (preview inspector)
    debugImplementation(libs.androidx.compose.ui.tooling)

    // --- Unit tests ---
    testImplementation(libs.junit)

    // --- Instrumentation / UI tests (optional but recommended) ---
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.androidx.test.rules)

    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)

    // Needed sometimes to avoid "No instrumentation registered" in UI tests
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}

/**
 * Publish AAR + sources to GitHub Packages using Gradle Maven Publish.
 * GitHub docs: authenticate via username + token.  [oai_citation:3‡GitHub Docs](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry?utm_source=chatgpt.com)
 */
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])

                artifactId = "screenutil-compose"

                pom {
                    name.set("screenutil-compose")
                    description.set("ScreenUtil-style scaling helpers for Jetpack Compose")
                    url.set("https://github.com/youseflabs-k/screenutils-compose")

                    licenses {
                        license {
                            name.set("MIT")
                            url.set("https://opensource.org/licenses/MIT")
                        }
                    }
                    scm {
                        url.set("https://github.com/youseflabs-k/screenutils-compose")
                        connection.set("scm:git:https://github.com/youseflabs-k/screenutils-compose.git")
                        developerConnection.set("scm:git:ssh://github.com/youseflabs-k/screenutils-compose.git")
                    }
                    developers {
                        developer {
                            id.set("Ahmedmmy97")
                            name.set("Ahmed Yousef")
                            url.set("https://github.com/Ahmedmmy97")
                        }
                    }
                }
            }
        }

        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/youseflabs-k/screenutils-compose")
                credentials {
                    username = (project.findProperty("gpr.user") as String?) ?: System.getenv("GITHUB_ACTOR")
                    password = (project.findProperty("gpr.token") as String?) ?: System.getenv("GITHUB_TOKEN")
                }
            }
            maven {
                name = "staging"
                url = uri(layout.buildDirectory.dir("staging-deploy"))
            }
        }
    }
}