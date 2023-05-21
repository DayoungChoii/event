package com.event.domain.partner

import com.event.domain.BaseEntity
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
@DynamicUpdate
class Partner constructor(
    var phoneNumber: String?,
    var address: String?,
    var name: String,
    @Id @GeneratedValue
    val id : Long? = null,
): BaseEntity() {
    companion object {
        fun fixture(
            phoneNumber: String = "01011111111",
            address: String = "서울시 뫄뫄구 뫄뫄동",
            name: String = "파트너사A",
            id: Long? = null
        ): Partner = Partner(phoneNumber, address, name, id)
    }

    fun changePhoneNumber(phoneNumber: String) {
        this.phoneNumber = phoneNumber
    }

    fun changeAddress(address: String) {
        this.address = address
    }

    fun changeName(name: String) {
        this.name = name
    }
}