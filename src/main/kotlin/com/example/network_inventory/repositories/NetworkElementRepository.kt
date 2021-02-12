package com.example.network_inventory.repositories

import com.example.network_inventory.model.NetworkElement
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface NetworkElementRepository : CrudRepository<NetworkElement, Long> {

    fun findByName(name: String): Iterable<NetworkElement>
}
