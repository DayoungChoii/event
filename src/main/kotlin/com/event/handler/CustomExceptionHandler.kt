package com.event.handler

import com.event.util.logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import kotlin.math.log

@RestControllerAdvice
class CustomExceptionHandler {

    val logger = logger()
    @ExceptionHandler
    fun handleIllegalStateException(ex: CustomException): ResponseEntity<ErrorMessage> {

        logger.info(ex.message)

        val errorMessage = ErrorMessage(
            HttpStatus.INTERNAL_SERVER_ERROR,
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.NOT_MODIFIED)
    }
}