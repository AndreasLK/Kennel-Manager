package com.example.kennelmanagercompose.domain.models.events

import com.android.identity.util.UUID
import com.example.kennelmanagercompose.core.Entity
import com.example.kennelmanagercompose.domain.enums.Severity
import java.time.Instant

data class ObservationLog(
    override val id: String = UUID.randomUUID().toString(),
    val date: Instant,
    val description: String,
    val severity: Severity,
    val staffId: String,

    val dogId: String?,
    val cageId: String?,
    val runId: String?
) : Entity
