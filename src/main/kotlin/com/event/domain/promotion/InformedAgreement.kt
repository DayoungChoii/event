package com.event.domain.promotion

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class InformedAgreement (
    val agreement: String,
    @ManyToOne
    @JoinColumn(name = "promotionId")
    val promotion: Promotion,
    @Id @GeneratedValue
    val id: Long,
){
}