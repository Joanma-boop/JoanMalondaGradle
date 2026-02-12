plugins {
    id("java")
    application
}
fun isWindows() = System.getProperty("os.name").lowercase().contains("win")

tasks.register<Exec>("ollamaVersion") {
    if (isWindows()) {
        commandLine("cmd", "/c", "ollama --version")
    } else {
        commandLine("bash", "-lc", "ollama --version")
    }
}

tasks.register<Exec>("ollamaPs") {
    if (isWindows()) {
        commandLine("cmd", "/c", "ollama ps")
    } else {
        commandLine("bash", "-lc", "ollama ps")
    }
}

tasks.register("llmInfo") {
    dependsOn("ollamaVersion", "ollamaPs")

    doLast {
        println("Demo finalizada")
    }
}



application {
    mainClass.set("com.joanmalonda.tema4gradle")
}

group = "com.joanmalonda.tema4gradle"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(platform("dev.langchain4j:langchain4j-bom:1.10.0"))
    implementation("dev.langchain4j:langchain4j-open-ai")

}


tasks.test {
    useJUnitPlatform()
}