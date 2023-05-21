package com.event.admin.partner.service

import com.event.admin.partner.service.dto.reqeust.PartnerAddRequest
import com.event.admin.partner.service.dto.reqeust.PartnerModifyRequest
import com.event.admin.partner.service.dto.reqeust.PartnerSearchDto
import com.event.admin.partner.service.dto.response.PartnersResponse
import org.springframework.data.domain.Pageable

interface PartnerService {
    fun savePartner(request: PartnerAddRequest)

    fun modifyPartner(request: PartnerModifyRequest)

    fun getPartners(partnerSearchDto: PartnerSearchDto,
                    pageable: Pageable
    ): List<PartnersResponse>
}