package com.event.domain.promotion

import org.springframework.data.jpa.repository.JpaRepository

interface PromotionRepository: JpaRepository<Promotion, Long>{
}