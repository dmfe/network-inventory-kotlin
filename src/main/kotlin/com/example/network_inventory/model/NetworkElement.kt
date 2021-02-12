package com.example.network_inventory.model

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "network_element")
data class NetworkElement(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    val name: String? = null,

    val ip: String? = null,

    val type: String? = null,

    val vendor: String? = null,

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hw_component_id")
    val hwComponent: HardwareComponent? = null
)
