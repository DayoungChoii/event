package com.event.admin.partner.service

import com.event.admin.partner.service.dto.reqeust.PartnerAddRequest
import com.event.admin.partner.service.dto.reqeust.PartnerModifyRequest
import com.event.admin.partner.service.dto.reqeust.PartnerSearchDto
import com.event.admin.partner.service.dto.response.PartnersResponse
import com.event.domain.partner.repository.PartnerQuerydslRepository
import com.event.domain.partner.repository.PartnerRepository
import com.event.exception.partner.PartnerException
import com.event.util.findByIdOrThrow
import lombok.extern.slf4j.Slf4j
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Slf4j
class PartnerServiceImpl (
    private val partnerRepository: PartnerRepository,
    private val partnerQuerydslRepository: PartnerQuerydslRepository,
): PartnerService {
    @Transactional
    override fun savePartner(request: PartnerAddRequest) {
        try {
            partnerRepository.save(request.toEntity())
        } catch (e: Exception) {
            throw PartnerException("PartnerSaveFailureException: PartnerName: ${request.name}", e)
        }

    }

    @Transactional
    override fun modifyPartner(request: PartnerModifyRequest) {
        var partner = partnerRepository.findByIdOrThrow(request.id)
        request.name?.apply { partner.changeName(request.name) }
        request.address?.apply {partner.changeAddress(request.address)}
        request.phoneNumber?.apply {partner.changePhoneNumber(request.phoneNumber)}
    }

    @Transactional
    override fun getPartners(partnerSearchDto: PartnerSearchDto,
                             pageble: Pageable
    ): List<PartnersResponse> {
        try {
            return partnerQuerydslRepository.findAll(partnerSearchDto, pageble)
                ?.map { it -> PartnersResponse.from(it) } ?: emptyList()
        } catch (e: Exception) {
            throw PartnerException("GetPartnersFailureException", e)
        }

    }
}