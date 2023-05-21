package com.event.admin.partner.controller

import com.event.admin.partner.service.PartnerService
import com.event.admin.partner.service.dto.reqeust.PartnerAddRequest
import com.event.admin.partner.service.dto.reqeust.PartnerModifyRequest
import com.event.admin.partner.service.dto.reqeust.PartnerSearchDto
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PartnerController (
    private val partnerService: PartnerService,
) {
    @PostMapping("/partner")
    fun addPartner(@RequestBody request: PartnerAddRequest): ResponseEntity<Any> {
        partnerService.savePartner(request)
        return ResponseEntity
            .ok()
            .body(true)
    }

    @PatchMapping("/partner")
    fun modifyPartner(@RequestBody request: PartnerModifyRequest): ResponseEntity<Any> {
        partnerService.modifyPartner(request)
        return ResponseEntity
            .ok()
            .body(true)
    }

    @GetMapping("/partner")
    fun getPartners(partnerSearchDto: PartnerSearchDto,
                    pageRequest: PageRequest,
    ): ResponseEntity<Any> {
        return ResponseEntity
            .ok()
            .body(partnerService.getPartners(partnerSearchDto, pageRequest))
    }


}