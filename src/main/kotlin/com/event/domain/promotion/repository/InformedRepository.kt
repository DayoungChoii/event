package com.event.domain.promotion.repository

import com.event.domain.promotion.InformedAgreement
import org.springframework.data.jpa.repository.JpaRepository

interface InformedRepository: JpaRepository<InformedAgreement, Long> {
    fun findByPromotionId(promotionId: Long): List<InformedAgreement>
}