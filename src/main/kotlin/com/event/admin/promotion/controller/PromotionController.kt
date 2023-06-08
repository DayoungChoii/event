package com.event.admin.promotion.controller

import com.event.admin.promotion.service.PromotionService
import com.event.admin.promotion.service.dto.request.PromotionAddRequest
import com.event.admin.promotion.service.dto.request.PromotionModifyRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PromotionController (
    private val promotionService: PromotionService,
) {

    @PostMapping("/promotion")
    fun savePromotion(@RequestBody request: PromotionAddRequest):ResponseEntity<Any> {
        return ResponseEntity.ok(promotionService.savePromotion(request))
    }

    @PatchMapping("/promotion")
    fun modifyPromotion(@RequestBody request: PromotionModifyRequest):ResponseEntity<Any> {
        return ResponseEntity.ok(promotionService.modifyPromotion(request))
    }
}