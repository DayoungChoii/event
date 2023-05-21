package com.event.domain.application.repository

import com.event.domain.application.Application
import org.springframework.data.jpa.repository.JpaRepository

interface ApplicationRepository: JpaRepository<Application, Long> {
}