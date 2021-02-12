package com.example.network_inventory.controllers

import com.example.network_inventory.model.NetworkElement
import com.example.network_inventory.services.NetworkElementService
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
@RequestMapping("/v1/network-elements")
class NetworkElementController(
    private val networkElementService: NetworkElementService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllNetworkElements() = networkElementService.findAllNetworkElements()

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getNetworkElementById(@PathVariable id: Long) = networkElementService.findNetworkElementById(id)

    @GetMapping("/by_name")
    @ResponseStatus(HttpStatus.OK)
    fun getNetworkElementByName(@RequestParam name: String) = networkElementService.findNetworkElementByName(name)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createNetworkElement(@RequestBody networkElement: NetworkElement) =
        networkElementService.saveNetworkElement(networkElement)
}
