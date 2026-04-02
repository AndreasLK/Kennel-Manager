package com.example.kennelmanagercompose.versioncontrol.domain.models

import com.example.kennelmanagercompose.versioncontrol.domain.enums.ChangeTarget
import com.example.kennelmanagercompose.versioncontrol.domain.enums.RequestStatus
import java.time.Instant

/**
 * A "Git-style" change request for any entity.
 * @param T The type of the entity being changed (e.g., Dog, VaccineLog, Cage).
 */
data class KennelChangeRequest<T>(
    val id: String,
    val targetType: ChangeTarget,
    val parentId: String,          // The ID of the owner (e.g., the Dog's ID)
    val originalState: T?,         // Null if adding something new
    val proposedState: T?,         // Null if deleting something
    val requestedBy: String,       // The "Author" of the change
    val status: RequestStatus = RequestStatus.PENDING,
    val timestamp: Instant = Instant.now()
)