package com.event.domain.partner

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Partner constructor(
    val address: String?,
    val name: String?,
    @Id @GeneratedValue
    val id : Long,
){
}