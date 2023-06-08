package com.event.exception.promotion

import com.event.handler.CustomException


class PromotionException(
    message: String?,
    cause: Throwable?,
 ) : CustomException(message, cause) {

}