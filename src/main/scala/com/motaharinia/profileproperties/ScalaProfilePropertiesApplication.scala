package com.motaharinia.profileproperties

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = Array("com.motaharinia"))
class ScalaProfilePropertiesApplication

object ScalaProfilePropertiesApplication extends App {
    SpringApplication.run(classOf[ScalaProfilePropertiesApplication]);
}

