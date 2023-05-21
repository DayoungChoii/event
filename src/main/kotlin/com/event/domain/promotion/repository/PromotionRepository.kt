package com.event.domain.promotion.repository

import com.event.domain.promotion.Promotion
import org.springframework.data.jpa.repository.JpaRepository

interface PromotionRepository: JpaRepository<Promotion, Long>{
}