package com.example.kennelmanagercompose.versioncontrol.domain.models

import com.example.kennelmanagercompose.core.domain.interfaces.Entity
import com.example.kennelmanagercompose.versioncontrol.domain.enums.ChangeTarget
import com.example.kennelmanagercompose.versioncontrol.domain.enums.ChangeType
import com.example.kennelmanagercompose.versioncontrol.domain.enums.RequestStatus
import java.time.Instant
import java.util.UUID

/**
 * A "Git-style" change request for any entity.
 * @param Entity The type of the entity being changed (e.g., Dog, VaccineLog, Cage).
 */
data class KennelChangeRequest(
    override val id: String = UUID.randomUUID().toString(),
    val targetType: ChangeTarget,
    val changeType: ChangeType,
    val parentId: String,          // The ID of the owner (e.g., the Dog's ID)
    val originalState: Entity?,         // Null if adding something new
    val proposedState: Entity?,         // Null if deleting something
    val requestedBy: String,       // The "Author" of the change
    val status: RequestStatus = RequestStatus.PENDING,
    val timestamp: Instant = Instant.now()
): Entity