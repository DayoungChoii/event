package com.event.handler

import org.springframework.http.HttpStatus

class ErrorMessage(
    val status: HttpStatus,
    val message: String?,
) {
}