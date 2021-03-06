package com.example.network_inventory.services

import com.example.network_inventory.exceptions.ObjectNotFoundException
import com.example.network_inventory.model.HardwareComponent
import com.example.network_inventory.model.NetworkElement
import com.example.network_inventory.repositories.HardwareComponentRepository
import com.example.network_inventory.repositories.NetworkElementRepository
import org.springframework.stereotype.Service

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
    override fun findNetworkElementById(id: Long): NetworkElement {
        return networkElementRepository.findById(id).orElseThrow {
            ObjectNotFoundException("Network Element with id: $id not found.")
        }
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
    override fun findHardwareComponentByNeId(neId: Long): HardwareComponent {
        return hardwareComponentRepository.findByNeId(neId).orElseThrow {
            ObjectNotFoundException("Network element with id: $neId not found.")
        }
    }

    @Override
    override fun findHardwareComponentById(id: Long): HardwareComponent {
        return hardwareComponentRepository.findById(id).orElseThrow{
            ObjectNotFoundException("Hardware component with id: $id not found.")
        }
    }

    @Override
    override fun findHardwareComponentByName(name: String): Iterable<HardwareComponent> {
        return hardwareComponentRepository.findByName(name)
    }

    @Override
    override fun saveHardwareComponent(neId: Long, hardwareComponent: HardwareComponent): Long {
        val ne = networkElementRepository.findById(neId).orElseThrow{
            ObjectNotFoundException("Network element with id: $neId not found.")
        }
        hardwareComponent.networkElement = ne

        return hardwareComponentRepository.save(hardwareComponent).id ?: 0
    }
}
