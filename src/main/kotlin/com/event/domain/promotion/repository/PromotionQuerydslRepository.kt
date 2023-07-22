package com.event.domain.promotion.repository

import com.event.admin.promotion.service.dto.request.PromotionSearchDto
import com.event.domain.partner.QPartner.partner
import com.event.domain.promotion.Promotion
import com.event.domain.promotion.QPromotion.promotion
import com.event.util.withPageable
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class PromotionQuerydslRepository (
    private val queryFactory: JPAQueryFactory,
){

    fun findAll(searchDto: PromotionSearchDto,
                pageable: Pageable)
    : List<Promotion>? {
        return queryFactory.selectFrom(promotion)
            .innerJoin(promotion.partner, partner)
            .fetchJoin()
            .where(searchDto.name?.let { promotion.name.like(searchDto.name)})
            .orderBy(promotion.id.desc())
            .withPageable(pageable)
            .fetch()
    }
}