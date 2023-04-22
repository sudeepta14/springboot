package com.unicorn.springbootapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testRestController {
    // expose a slash endpoint that will simply return hello world
    @GetMapping("/")
        public String sayHello(){
            return "Hello World";
        }
}
