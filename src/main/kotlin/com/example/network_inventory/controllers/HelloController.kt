package com.example.network_inventory.controllers

import com.example.network_inventory.model.HelloDto
import com.example.network_inventory.services.HelloService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(private val helloService: HelloService) {

    @GetMapping("/hello")
    fun helloKotlin() = "hello world"

    @GetMapping("hello-service")
    fun helloFromService() = helloService.getHello()

    @GetMapping("hello-dto")
    fun helloDto() = HelloDto("Hello from DTO")
}