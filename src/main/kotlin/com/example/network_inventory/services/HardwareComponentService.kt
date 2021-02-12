package com.example.network_inventory.services

import com.example.network_inventory.model.HardwareComponent
import java.util.Optional

interface HardwareComponentService {

    fun findAllHardwareComponents(): Iterable<HardwareComponent>
    fun findHardwareComponentById(id: Long): Optional<HardwareComponent>
    fun findHardwareComponentByName(name: String): Iterable<HardwareComponent>
    fun saveHardwareComponent(hardwareComponent: HardwareComponent): Long
}