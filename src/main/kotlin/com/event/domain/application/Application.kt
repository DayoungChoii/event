package com.event.domain.application

import com.event.domain.promotion.Promotion
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Application (
    val address: String,
    val age: Int,
    val email: String,
    @Column(name = "state")
    val applicationState: ApplicationStateType = ApplicationStateType.WAIT,
    @OneToOne
    val promotion: Promotion,
    @Id @GeneratedValue
    val id: Long,
){
}