package com.event.admin.promotion.service

import com.event.admin.promotion.service.dto.request.PromotionAddRequest
import com.event.admin.promotion.service.dto.request.PromotionModifyRequest
import com.event.admin.promotion.service.dto.request.PromotionSearchDto
import com.event.admin.promotion.service.dto.response.PromotionResponse
import org.springframework.data.domain.Pageable

interface PromotionService {
    fun savePromotion(request: PromotionAddRequest)

    fun modifyPromotion(request: PromotionModifyRequest)

    fun finishPromotion(promotionId: Long)

    fun getPromotions(promotionSearchDto: PromotionSearchDto, pageable: Pageable) : List<PromotionResponse>

}
