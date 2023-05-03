package com.event.admin.partner.service.dto.reqeust

import com.event.domain.partner.Partner

data class PartnerAddRequest (

    val phoneNumber: String? = null,
    val address: String? = null,
    val name: String,
){
    fun toEntity(): Partner {
        return Partner(
            phoneNumber = this.phoneNumber,
            address = this.address,
            name = this.name
        )
    }
}