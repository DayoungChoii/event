package com.event.admin.promotion.service.dto.response

import com.event.domain.partner.Partner
import com.event.domain.promotion.Promotion
import com.event.domain.promotion.constant.PromotionStateType
import java.time.Instant

data class PromotionResponse (
    val name: String,
    val startDate: Instant,
    val endDate: Instant,
    val state: PromotionStateType,
    val partner: Partner,
) {
    companion object {
        fun from(promotion: Promotion): PromotionResponse {
            return PromotionResponse(
                name = promotion.name,
                startDate = promotion.startDate,
                endDate = promotion.endDate,
                state = promotion.state,
                partner = promotion.partner!!
            )
        }
    }
}