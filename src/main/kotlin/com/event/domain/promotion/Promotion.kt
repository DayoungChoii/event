package com.event.domain.promotion

import com.event.domain.BaseEntity
import com.event.domain.partner.Partner
import com.event.domain.promotion.constant.PromotionStateType
import java.time.Instant
import java.time.temporal.ChronoUnit
import javax.persistence.*

@Entity
class Promotion constructor(
    var name: String,
    var content: String,
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "promotion", cascade = [CascadeType.PERSIST])
    var informedAgreements: List<InformedAgreement>? = emptyList(),
    var startDate: Instant,
    var endDate: Instant,
    @Column(name = "state")
    var state: PromotionStateType,
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id")
    val partner: Partner? = null,
    @Id @GeneratedValue
    val id: Long? = null,
) : BaseEntity() {

    companion object {
        fun fixture() = Promotion(
            name = "A 이벤트",
            content = "A 이벤트 콘텐츠",
            startDate = Instant.now().plus(1, ChronoUnit.DAYS),
            endDate = Instant.now().plus(3, ChronoUnit.DAYS),
            state = PromotionStateType.OPEN
        )
    }

    fun changeName(name: String) {
        this.name = name
    }

    fun changeContent(content: String) {
        this.content = content
    }

    fun changeStartDate(startDate: Instant) {
        this.startDate = startDate
    }

    fun changeEndDate(endDate: Instant) {
        this.endDate = endDate
    }

    fun changeInformedAgreements(informedAgreements: List<InformedAgreement>?) {
        this.informedAgreements = informedAgreements
    }

    fun assignInformedAgreements(informedAgreements: List<InformedAgreement>?) {
        this.informedAgreements = informedAgreements
    }

    fun finish() {
        this.state = PromotionStateType.CLOSE
    }

}