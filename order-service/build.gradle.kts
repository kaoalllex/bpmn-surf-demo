plugins {
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.spring") version "2.0.21"
    id("org.springframework.boot") version "3.3.5"
}

dependencies {
    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter:7.22.0")
    implementation("org.camunda.bpm:camunda-external-task-client-spring-boot-starter:7.22.0")
    implementation("org.springframework.kafka:spring-kafka")
}
