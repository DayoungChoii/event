package com.event.admin.promotion.service

import com.event.admin.promotion.service.dto.request.PromotionAddRequest
import com.event.admin.promotion.service.dto.request.PromotionModifyRequest
import com.event.admin.promotion.service.dto.request.PromotionSearchDto
import com.event.domain.promotion.repository.InformedRepository
import com.event.domain.promotion.repository.PromotionRepository
import com.event.exception.promotion.PromotionException
import com.event.util.findByIdOrThrow
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PromotionServiceImpl (
    private val promotionRepository: PromotionRepository,
    private val informedRepository: InformedRepository,
) : PromotionService{
    override fun savePromotion(request: PromotionAddRequest) {
        try {
            promotionRepository.save(request.toPromotion())
        } catch (e: Exception) {
            throw PromotionException("PromotionSaveFailureException promotion: ${request.name}", e)
        }
    }

    override fun modifyPromotion(request: PromotionModifyRequest) {
        val promotion = promotionRepository.findByIdOrThrow(request.id)
        promotion.informedAgreements?.get(0)
        promotion.changeName(request.name)
        promotion.changeContent(request.content)
        promotion.changeStartDate(request.startDate)
        promotion.changeEndDate(request.endDate)

        promotion.informedAgreements?.forEach { it -> informedRepository.deleteById(it.id!!) }
        promotion.changeInformedAgreements(request.informedAgreements.map{ it -> it.toInformedAgreement(promotion) })
    }

    override fun finishPromotion(promotionId: Long) {
        val promotion = promotionRepository.findByIdOrThrow(promotionId)
        promotion.finish()
    }

    @Transactional(readOnly = true)
    override fun getPromotions(promotionSearchDto: PromotionSearchDto, pageRequest: PageRequest) {
        TODO("Not yet implemented")
    }
}