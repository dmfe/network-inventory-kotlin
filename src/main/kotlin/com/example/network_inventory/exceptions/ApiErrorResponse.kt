package com.example.network_inventory.exceptions

import org.springframework.http.HttpStatus

data class ApiErrorResponse(
    val code: HttpStatus,
    val message: String
)
