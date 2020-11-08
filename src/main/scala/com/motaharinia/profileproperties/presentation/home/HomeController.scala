package com.motaharinia.profileproperties.presentation.home

import com.motaharinia.profileproperties.ScalaProfilePropertiesApplication
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.{GetMapping, PostMapping, RestController};


@RestController
class HomeController {

    @Value("${spring.application.name}")
    var  springApplicationName : String = ""

    @Value("${app.randomInt}")
    var  appRandomInt: Integer = _


    @GetMapping(path = Array("/"))
    def getUrl():ResponseEntity[String]= {
         new ResponseEntity[](springApplicationName)
    }

    @PostMapping(path = Array("/randomInt"))
    def getRandomInt(@Validated profilePropertiesApplication: ScalaProfilePropertiesApplication ):Integer ={
        appRandomInt
    }



}
