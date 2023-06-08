package com.event.domain.promotion

import com.event.domain.BaseEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class InformedAgreement (
    val agreement: String,
    @ManyToOne
    @JoinColumn(name = "promotion_id")
    var promotion: Promotion? = null,
    @Id @GeneratedValue
    val id: Long? = null,
): BaseEntity() {

    companion object {
        fun fixture(): List<InformedAgreement> {
            return listOf(
                    InformedAgreement("사전동의1"),
                    InformedAgreement("사전동의2"),
                    InformedAgreement("사전동의3")
            )
        }
    }
}