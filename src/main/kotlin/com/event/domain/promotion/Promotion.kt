package com.event.domain.promotion

import com.event.domain.partner.Partner
import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Entity
class Promotion(
    val name: String,
    val content: String,
    @OneToMany(mappedBy = "promotion")
    val informedAgreements: List<InformedAgreement>,
    val startDate: Instant,
    val endDate: Instant,
    val state: PromotionStateType = PromotionStateType.OPEN,
    @OneToOne
    @JoinColumn(name = "partnerId")
    val partner: Partner,
    @Id @GeneratedValue
    val id: Long,
) {
}