package com.event.domain.partner.repository

import com.event.domain.partner.Partner
import org.springframework.data.jpa.repository.JpaRepository

interface PartnerRepository: JpaRepository<Partner, Long> {
}