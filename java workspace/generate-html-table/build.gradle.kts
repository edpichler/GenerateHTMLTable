plugins {
    `java-library`
    `maven-publish`
}

afterEvaluate {
    version = file("version.txt").readText().trim();
    group = "com.easypnr"
}
protected val javaTargetVersion = 17;

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaTargetVersion))
    }

}
dependencies {
    testImplementation(libs.bundles.testing)
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven {
        credentials {
            username = findProperty("NEXUS_USERNAME") as String
            password = findProperty("NEXUS_PASSWORD") as String
        }
        url = uri("https://nexus.easypnr.com/repository/maven-third-party/")
    }
    maven {
        credentials {
            username = findProperty("NEXUS_USERNAME") as String
            password = findProperty("NEXUS_PASSWORD") as String
        }
        url = uri("https://nexus.easypnr.com/repository/maven-easypnr/")
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            pom {
                name.set("easyPNR-core")
                description.set("Core library")
                url.set("https://github.com/edpichler/easypnr-core")
                properties.set(
                    mapOf(
                        "Copyright" to "easypnr.com",
                    ),
                )
                licenses {
                    license {
                        name.set("EasyPNR License")
                        url.set("http://www.easypnr.com")
                    }
                }
                developers {
                    developer {
                        id.set("edu")
                        name.set("Edu Pichler")
                        email.set("pichler@easypnr.com")
                    }
                }
            }
        }
    }
    repositories {
        maven {
            credentials {
                username = findProperty("NEXUS_USERNAME") as String
                password = findProperty("NEXUS_PASSWORD") as String
            }
            url = uri("https://nexus.easypnr.com/repository/maven-easypnr/")
        }
    }
}