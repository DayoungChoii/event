package com.event.domain.promotion

import com.event.domain.partner.Partner
import com.event.domain.promotion.constant.PromotionStateType
import java.time.Instant
import javax.persistence.*

@Entity
class Promotion(
    val name: String,
    val content: String,
    @OneToMany(mappedBy = "promotion")
    val informedAgreements: List<InformedAgreement>,
    val startDate: Instant,
    val endDate: Instant,
    @Column(name = "state")
    val state: PromotionStateType = PromotionStateType.OPEN,
    @OneToOne
    @JoinColumn(name = "partnerId")
    val partner: Partner,
    @Id @GeneratedValue
    val id: Long,
) {
}