package com.event.admin.partner.service.dto.reqeust

import com.event.domain.partner.Partner

data class PartnerModifyRequest(
    val phoneNumber: String? = null,
    val address: String? = null,
    val name: String,
    val id: Long,
) {

}
