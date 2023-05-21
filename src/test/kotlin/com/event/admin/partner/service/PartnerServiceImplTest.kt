package com.event.admin.partner.service

import com.event.admin.partner.service.dto.reqeust.PartnerAddRequest
import com.event.admin.partner.service.dto.reqeust.PartnerModifyRequest
import com.event.admin.partner.service.dto.reqeust.PartnerSearchDto
import com.event.domain.partner.Partner
import com.event.domain.partner.repository.PartnerRepository
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

@SpringBootTest
class PartnerServiceImplTest @Autowired constructor(
    private val partnerService: PartnerService,
    private val partnerRepository: PartnerRepository,
) {
    val partner = Partner.fixture()

    @AfterEach
    fun clear() {
        partnerRepository.deleteAll()
    }
    @Test
    fun savePartnerTest () {
        // given
        val partnerAddRequest = PartnerAddRequest(name = "파트너사1")

        // when
        partnerService.savePartner(partnerAddRequest)

        // then
        val result = partnerRepository.findAll()
        assertThat(result).hasSize(1)
        assertThat(result[0].name).isEqualTo(partnerAddRequest.name)
    }

    @Test
    fun updatePartnerTest () {
        // given
        partnerRepository.save(partner)
        val request = PartnerModifyRequest(
            phoneNumber = "0102222222",
            address = "부산시 뫄뫄구 뫄뫄동",
            name = "파트너사 수정",
            id = partner.id!!
        )

        // when
        partnerService.modifyPartner(request)

        // then
        val result = partnerRepository.findAll()
        assertThat(result).hasSize(1)
        assertThat(result[0].phoneNumber).isEqualTo(request.phoneNumber)
        assertThat(result[0].address).isEqualTo(request.address)
        assertThat(result[0].name).isEqualTo(request.name)
    }

    @Test
    fun getPartnersTest() {
        // given
        partnerRepository.save(Partner.fixture(name = "파트너사A"))
        partnerRepository.save(Partner.fixture(name = "파트너사B"))
        partnerRepository.save(Partner.fixture(name = "파트너사C"))
        partnerRepository.save(Partner.fixture(name = "파트너사D"))
        partnerRepository.save(Partner.fixture(name = "파트너사E"))

        // when
        val partners = partnerService.getPartners(PartnerSearchDto(null, null), PageRequest.of(0, 3))

        // then
        assertThat(partners).hasSize(3);
        assertThat(partners).extracting("name").containsExactly("파트너사A", "파트너사B", "파트너사C")
    }

    @Test
    fun getPartnersWithSearch() {
        // given
        partnerRepository.save(Partner.fixture(name = "파트너사A"))
        partnerRepository.save(Partner.fixture(name = "파트너사B"))
        partnerRepository.save(Partner.fixture(name = "파트너사C"))
        partnerRepository.save(Partner.fixture(name = "파트너사D"))
        partnerRepository.save(Partner.fixture(name = "파트너사E"))

        // when
        val partners = partnerService.getPartners(PartnerSearchDto(null, "파트너사A"), PageRequest.of(0, 3))

        // then
        assertThat(partners).hasSize(1)
        assertThat(partners).extracting("name").containsExactly("파트너사A")
    }
}