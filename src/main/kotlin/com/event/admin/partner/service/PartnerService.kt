package com.event.admin.partner.service

import com.event.admin.partner.service.dto.reqeust.PartnerAddRequest
import com.event.admin.partner.service.dto.reqeust.PartnerModifyRequest
import com.event.admin.partner.service.dto.response.PartnersResponse
import com.event.domain.partner.Partner

interface PartnerService {
    fun savePartner(request: PartnerAddRequest)

    fun modifyPartner(request: PartnerModifyRequest)

    fun getPartners(): List<PartnersResponse>
}