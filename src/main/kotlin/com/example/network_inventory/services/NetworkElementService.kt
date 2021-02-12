package com.example.network_inventory.services

import com.example.network_inventory.model.NetworkElement
import java.util.Optional

interface NetworkElementService {

    fun findAllNetworkElements(): Iterable<NetworkElement>
    fun findNetworkElementById(id: Long): Optional<NetworkElement>
    fun findNetworkElementByName(name: String): Iterable<NetworkElement>
    fun saveNetworkElement(networkElement: NetworkElement): Long
}