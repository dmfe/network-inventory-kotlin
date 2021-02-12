package com.example.network_inventory.repositories

import com.example.network_inventory.model.HardwareComponent
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HardwareComponentRepository : CrudRepository<HardwareComponent, Long> {

    fun findByName(name: String): Iterable<HardwareComponent>
}
