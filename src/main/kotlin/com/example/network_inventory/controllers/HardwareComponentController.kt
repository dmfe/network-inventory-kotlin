package com.example.network_inventory.controllers

import com.example.network_inventory.model.HardwareComponent
import com.example.network_inventory.services.HardwareComponentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/hardware-components")
class HardwareComponentController(
    private val hardwareComponentService: HardwareComponentService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllHardwareComponents() = hardwareComponentService.findAllHardwareComponents()

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getHardwareComponentById(@PathVariable id: Long) = hardwareComponentService.findHardwareComponentById(id)

    @GetMapping("/by_name")
    @ResponseStatus(HttpStatus.OK)
    fun getHardwareComponentByName(@RequestParam name: String) =
        hardwareComponentService.findHardwareComponentByName(name)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createHardwareComponent(@RequestBody hardwareComponent: HardwareComponent) =
        hardwareComponentService.saveHardwareComponent(hardwareComponent)
}
