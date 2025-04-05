plugins {
    id("net.sf.robocode.java-conventions")
    `java-library`
}

dependencies {
    implementation(project(":robocode.api"))
    implementation(testLibs.junit)

    testImplementation(project(":robocode.core"))
    testImplementation(project(":robocode.host"))
    testImplementation(project(":robocode.battle"))
    testImplementation(project(":robocode.tests.robots"))
}

description = "Robocode Tests"

tasks {
    publishMavenJavaPublicationToSonatypeRepository {
        enabled = false
    }

    test {
        useJUnitPlatform() // If you're using JUnit 5 (JUnit Platform) or similar

        // Exclude specific test classes (using fully qualified names)
        exclude("net/sf/robocode/test/robots/TestPosition.class")
        exclude("net/sf/robocode/test/TestConstructorThreadAttack.class")
        exclude("net/sf/robocode/test/TestDuplicatesAndScore.class")

        //Remove wildcard ones
    }
}