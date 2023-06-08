package com.event.admin.promotion.service.dto.request

import com.event.domain.promotion.InformedAgreement
import com.event.domain.promotion.Promotion
import com.event.domain.promotion.constant.PromotionStateType
import org.jetbrains.annotations.NotNull
import java.time.Instant

data class PromotionAddRequest (
    val name: String,
    val content: String,
    val startDate: Instant,
    val endDate: Instant,
    val state: PromotionStateType,
    val informedAgreements: List<InformedAgreementRequest>
) {
    fun toPromotion(): Promotion {
        val promotion = Promotion(
            name = this.name,
            content = this.content,
            startDate = this.startDate,
            endDate = this.endDate,
            state = this.state,
        )
        promotion.assignInformedAgreements(informedAgreements.map { it -> it.toInformedAgreement(promotion) })
        return promotion
    }
}

data class InformedAgreementRequest (
    val agreement: String,
) {

    fun toInformedAgreement(promotion: Promotion): InformedAgreement {
        return InformedAgreement(agreement = this.agreement, promotion = promotion)
    }
}

data class PromotionModifyRequest (
    @NotNull
    val id: Long,
    val name: String,
    val content: String,
    val startDate: Instant,
    val endDate: Instant,
    val informedAgreements: List<InformedAgreementRequest>
){

}

data class PromotionSearchDto(
    val name: String,
) {}

