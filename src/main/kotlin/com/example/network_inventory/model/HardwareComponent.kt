package com.example.network_inventory.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "hardware_component")
data class HardwareComponent(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    val name: String? = null,

    val description: String? = null,

    @Column(name = "hardware_rev")
    val hardwareRev: String? = null,

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ne_id")
    val networkElement: NetworkElement? = null
)
