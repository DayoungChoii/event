package com.event.admin.promotion.service

import com.event.admin.promotion.service.dto.request.InformedAgreementRequest
import com.event.admin.promotion.service.dto.request.PromotionAddRequest
import com.event.admin.promotion.service.dto.request.PromotionModifyRequest
import com.event.domain.promotion.InformedAgreement
import com.event.domain.promotion.Promotion
import com.event.domain.promotion.constant.PromotionStateType
import com.event.domain.promotion.repository.InformedRepository
import com.event.domain.promotion.repository.PromotionRepository
import com.event.util.findByIdOrThrow
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional
import java.time.Instant
import java.time.temporal.ChronoUnit

@SpringBootTest
class PromotionServiceImplTest @Autowired constructor(
    private val promotionService: PromotionService,
    private val promotionRepository: PromotionRepository,
    private val informedRepository: InformedRepository,
 ) {

    private val promotionFixture: Promotion = Promotion.fixture()
    private val informedAgreementFixture: List<InformedAgreement> = InformedAgreement.fixture()
    @AfterEach
    fun clear() {
//        promotionRepository.deleteAll()
    }
    @Test
    fun promotionSaveTest(){
        // given
        val promotionAddRequest = PromotionAddRequest(
            name = "test",
            content = "test content",
            startDate = Instant.now(),
            endDate = Instant.now().plus(3, ChronoUnit.DAYS),
            state = PromotionStateType.OPEN,
            informedAgreements = listOf(
                InformedAgreementRequest("agree1"),
                InformedAgreementRequest("agree2")
            )
        )

        // when
        promotionService.savePromotion(promotionAddRequest)

        // then
        val foundPromotion = promotionRepository.findAll()
        val foundInformedAgreements = informedRepository.findByPromotionId(foundPromotion[0].id!!)
        assertThat(foundPromotion).hasSize(1)
        assertThat(foundPromotion[0].name).isEqualTo("test")
        assertThat(foundInformedAgreements).hasSize(2)
        assertThat(foundInformedAgreements[0].agreement).isEqualTo("agree1")
        assertThat(foundInformedAgreements[1].agreement).isEqualTo("agree2")
    }

    @Test
    fun promotionUpdateTest() {
        // given
        val promotion = promotionRepository.save(promotionFixture)
        informedAgreementFixture.map { it -> it.promotion = promotion }
        informedRepository.saveAll(informedAgreementFixture)
        val promotionModifyRequest = PromotionModifyRequest(
            name = "test_updated",
            content = "test content_updated",
            startDate = Instant.now().plus(1, ChronoUnit.DAYS),
            endDate = Instant.now().plus(4, ChronoUnit.DAYS),
            id = promotion.id!!,
            informedAgreements = listOf(
                InformedAgreementRequest("agree1_updated"),
                InformedAgreementRequest("agree2_updated")
            )
        )

        // when
        promotionService.modifyPromotion(promotionModifyRequest)

        // then
        val updatedPromotion = promotionRepository.findByIdOrThrow(promotion.id)
        val updatedInformedAgreement = informedRepository.findByPromotionId(updatedPromotion.id!!)
        assertThat(updatedPromotion.name).isEqualTo("test_updated")
        assertThat(updatedInformedAgreement[0].agreement).isEqualTo("agree1_updated")
        assertThat(updatedInformedAgreement[1].agreement).isEqualTo("agree2_updated")
    }

    @Test
    fun promotionFinishTest() {
        // given
        val promotion = promotionRepository.save(promotionFixture)

        // when
        promotionService.finishPromotion(promotion.id!!)

        // then
        val foundPromotion = promotionRepository.findByIdOrThrow(promotion.id)
        assertThat(foundPromotion.state).isEqualTo(PromotionStateType.CLOSE)
    }
}

