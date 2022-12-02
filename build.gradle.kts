val javaVersion = "18"

kotlin {
  jvmToolchain {
    this.languageVersion.set(JavaLanguageVersion.of(javaVersion))
  }
}

plugins {
  id("org.jetbrains.kotlin.jvm") version "1.7.22"
  id("com.diffplug.spotless") version "6.12.0"
  id("io.gitlab.arturbosch.detekt") version "1.22.0"
  application
}

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("org.jetbrains.kotlin:kotlin-test")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

detekt {
  // Turns on all the rules. `false` by default.
  allRules = true

  // Adds debug output during task execution. `false` by default.
  debug = false

  // If set to `true` the build does not fail when the
  // maxIssues count was reached. Defaults to `false`.
  ignoreFailures = false
}

spotless {
  kotlin {
    // version, setUseExperimental, userData and editorConfigOverride are all optional
    ktlint("0.47.1")
      .setUseExperimental(true)
      .editorConfigOverride(
        mapOf(
          "indent_size" to 2,
          "insert_final_newline" to true,
          "max_line_length" to 100
        )
      )
  }
}