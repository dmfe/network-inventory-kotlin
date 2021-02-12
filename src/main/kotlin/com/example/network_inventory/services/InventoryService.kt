package com.example.network_inventory.services

import com.example.network_inventory.model.HardwareComponent
import com.example.network_inventory.model.NetworkElement
import com.example.network_inventory.repositories.HardwareComponentRepository
import com.example.network_inventory.repositories.NetworkElementRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class InventoryService(
    private val networkElementRepository: NetworkElementRepository,
    private val hardwareComponentRepository: HardwareComponentRepository
)
    : NetworkElementService, HardwareComponentService {

    @Override
    override fun findAllNetworkElements(): Iterable<NetworkElement> {
        return networkElementRepository.findAll()
    }

    @Override
    override fun findNetworkElementById(id: Long): Optional<NetworkElement> {
        return networkElementRepository.findById(id)
    }

    @Override
    override fun findNetworkElementByName(name: String): Iterable<NetworkElement> {
        return networkElementRepository.findByName(name)
    }

    @Override
    override fun saveNetworkElement(networkElement: NetworkElement): Long {
        return networkElementRepository.save(networkElement).id ?: 0
    }

    @Override
    override fun findAllHardwareComponents(): Iterable<HardwareComponent> {
        return hardwareComponentRepository.findAll()
    }

    @Override
    override fun findHardwareComponentById(id: Long): Optional<HardwareComponent> {
        return hardwareComponentRepository.findById(id)
    }

    @Override
    override fun findHardwareComponentByName(name: String): Iterable<HardwareComponent> {
        return hardwareComponentRepository.findByName(name)
    }

    @Override
    override fun saveHardwareComponent(hardwareComponent: HardwareComponent): Long {
        return hardwareComponentRepository.save(hardwareComponent).id ?: 0
    }
}
