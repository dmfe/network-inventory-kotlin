package com.example.network_inventory

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class NetworkInventoryApplication

fun main(args: Array<String>) {
    SpringApplication.run(NetworkInventoryApplication::class.java, *args)
}
