package com.event.admin.partner.service

import com.event.admin.partner.service.dto.reqeust.PartnerAddRequest
import com.event.admin.partner.service.dto.reqeust.PartnerModifyRequest
import com.event.domain.partner.PartnerRepository
import com.event.util.findByIdOrThrow
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PartnerServiceImpl (
    private val partnerRepository: PartnerRepository,
): PartnerService {
    @Transactional
    override fun savePartner(request: PartnerAddRequest) {
        partnerRepository.save(request.toEntity())
    }

    @Transactional
    override fun modifyPartner(request: PartnerModifyRequest) {
        var partner = partnerRepository.findByIdOrThrow(request.id)
        request.name?.apply { partner.changeName(request.name) }
        request.address?.apply {partner.changeAddress(request.address)}
        request.phoneNumber?.apply {partner.changePhoneNumber(request.phoneNumber)}
    }


}