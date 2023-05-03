package com.event.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CustomExceptionHandler {

    @ExceptionHandler
    fun handleIllegalStateException(ex: CustomException): ResponseEntity<ErrorMessage> {

        val errorMessage = ErrorMessage(
            HttpStatus.INTERNAL_SERVER_ERROR,
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.NOT_MODIFIED)
    }
}