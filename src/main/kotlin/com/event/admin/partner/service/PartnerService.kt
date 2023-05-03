package com.event.admin.partner.service

import com.event.admin.partner.service.dto.reqeust.PartnerAddRequest
import com.event.admin.partner.service.dto.reqeust.PartnerModifyRequest

interface PartnerService {
    fun savePartner(request: PartnerAddRequest)

    fun modifyPartner(request: PartnerModifyRequest)
}