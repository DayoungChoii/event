package com.event.admin.promotion.service

import com.event.admin.promotion.service.dto.request.PromotionAddRequest
import com.event.admin.promotion.service.dto.request.PromotionModifyRequest
import com.event.admin.promotion.service.dto.request.PromotionSearchDto
import org.springframework.data.domain.PageRequest

interface PromotionService {
    fun savePromotion(request: PromotionAddRequest)

    fun modifyPromotion(request: PromotionModifyRequest)

    fun finishPromotion(promotionId: Long)

    fun getPromotions(promotionSearchDto: PromotionSearchDto, pageRequest: PageRequest)

}
