package com.example.network_inventory.exceptions

import com.example.network_inventory.controllers.HardwareComponentController
import com.example.network_inventory.controllers.NetworkElementController
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.IllegalArgumentException

@RestControllerAdvice(assignableTypes = [
    HardwareComponentController::class,
    NetworkElementController::class
])
class InventoryControllersHandler {

    @ExceptionHandler(ObjectNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(ex: Throwable) = createApiError(
        HttpStatus.NOT_FOUND,
        ex.localizedMessage
    )

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBadRequest(ex: Throwable) = createApiError(
        HttpStatus.BAD_REQUEST,
        ex.localizedMessage
    )

    @ExceptionHandler(Throwable::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleOthersServerErrors(ex: Throwable) = createApiError(
        HttpStatus.INTERNAL_SERVER_ERROR,
        ex.localizedMessage
    )

    private fun createApiError(code: HttpStatus, message: String) = ApiErrorResponse(
        code = code,
        message = message
    )
}
