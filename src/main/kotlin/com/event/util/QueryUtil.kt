package com.event.util

import com.querydsl.jpa.impl.JPAQuery
import org.springframework.data.domain.Pageable

fun <T> JPAQuery<T>.withPageable(pageable: Pageable): JPAQuery<T> {
    return this.limit(pageable.pageSize.toLong())
        .offset(pageable.offset)
}