import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
  //Kotlin
  `kotlin-dsl`
}

group = "com.heydenapps.arrowwords.buildlogic"

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
  compilerOptions {
    jvmTarget = JvmTarget.JVM_17
  }
}

dependencies {
  compileOnly(libs.gradle)
}

tasks {
  validatePlugins {
    enableStricterValidation = true
    failOnWarning = true
  }
}

gradlePlugin {
  plugins {
    register("androidApplicationJacoco") {
      id = libs.plugins.arrowwords.jacoco.application.get().pluginId
      implementationClass = "AndroidApplicationJacocoConventionPlugin"
    }
  }
}