package com.example.network_inventory.exceptions

import com.example.network_inventory.controllers.HardwareComponentController
import com.example.network_inventory.controllers.NetworkElementController
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(assignableTypes = [
    HardwareComponentController::class,
    NetworkElementController::class
])
class InventoryControllersHandler {

    @ExceptionHandler(ObjectNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(ex: Throwable): String = ex.localizedMessage
}
