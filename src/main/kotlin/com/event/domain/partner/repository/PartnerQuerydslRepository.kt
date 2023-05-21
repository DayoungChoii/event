package com.event.domain.partner.repository

import com.event.admin.partner.service.dto.reqeust.PartnerSearchDto
import com.event.domain.partner.Partner
import com.event.domain.partner.QPartner.partner
import com.event.util.withPageable
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class PartnerQuerydslRepository (
    private val queryFactory: JPAQueryFactory,
) {
    fun findAll(searchDto: PartnerSearchDto ,
                pageable: Pageable,)
    : MutableList<Partner>? {
        return queryFactory.select(partner)
            .from(partner)
            .where(searchDto.name?.let { partner.name.like(searchDto.name)},
                searchDto.phoneNumber?.let { partner.phoneNumber.like(searchDto.phoneNumber)})
            .withPageable(pageable)
            .fetch()
    }
}