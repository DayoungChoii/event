package com.event.handler

open class CustomException: RuntimeException {
    constructor(message: String?, cause: Throwable?) : super(message, cause)
}