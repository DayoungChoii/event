package com.event.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*


@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)

abstract class BaseEntity {
    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected var createdDate: LocalDateTime = LocalDateTime.MIN

    @LastModifiedDate
    @Column(nullable = false)
    protected var updatedDate: LocalDateTime = LocalDateTime.MIN

}