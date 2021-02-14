package com.example.network_inventory.repositories

import com.example.network_inventory.model.HardwareComponent
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface HardwareComponentRepository : CrudRepository<HardwareComponent, Long> {

    fun findByName(name: String): Iterable<HardwareComponent>

    @Query("select hw from HardwareComponent hw where ne_id = :ne_id")
    fun findByNeId(@Param("ne_id") neId: Long): Optional<HardwareComponent>
}
