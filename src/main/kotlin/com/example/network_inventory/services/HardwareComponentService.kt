package com.example.network_inventory.services

import com.example.network_inventory.model.HardwareComponent

interface HardwareComponentService {

    fun findAllHardwareComponents(): Iterable<HardwareComponent>
    fun findHardwareComponentByNeId(neId: Long): HardwareComponent
    fun findHardwareComponentById(id: Long): HardwareComponent
    fun findHardwareComponentByName(name: String): Iterable<HardwareComponent>
    fun saveHardwareComponent(neId: Long, hardwareComponent: HardwareComponent): Long
}
