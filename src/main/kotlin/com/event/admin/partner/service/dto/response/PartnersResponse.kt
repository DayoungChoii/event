package com.event.admin.partner.service.dto.response

import com.event.domain.partner.Partner

data class PartnersResponse(
    val phoneNumber: String?,
    val address: String?,
    val name: String,
) {
    companion object {
        fun from(partner: Partner): PartnersResponse {
            return PartnersResponse(
                phoneNumber = partner.phoneNumber,
                address =  partner.address,
                name = partner.name
            )
        }
    }
}


