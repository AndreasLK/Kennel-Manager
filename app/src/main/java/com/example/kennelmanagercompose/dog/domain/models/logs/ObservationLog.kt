package com.example.kennelmanagercompose.dog.domain.models.logs

import com.android.identity.util.UUID
import com.example.kennelmanagercompose.core.domain.interfaces.Entity
import com.example.kennelmanagercompose.dog.domain.enums.Severity
import java.time.Instant

data class ObservationLog(
    override val id: String = UUID.Companion.randomUUID().toString(),
    val date: Instant,
    val description: String,
    val severity: Severity,
    val staffId: String,

    val dogId: String?,
    val cageId: String?,
    val runId: String?
) : Entity