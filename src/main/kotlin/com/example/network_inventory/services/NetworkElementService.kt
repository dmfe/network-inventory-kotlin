package com.example.network_inventory.services

import com.example.network_inventory.model.NetworkElement

interface NetworkElementService {

    fun findAllNetworkElements(): Iterable<NetworkElement>
    fun findNetworkElementById(id: Long): NetworkElement
    fun findNetworkElementByName(name: String): Iterable<NetworkElement>
    fun saveNetworkElement(networkElement: NetworkElement): Long
}
