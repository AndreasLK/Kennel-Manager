package com.example.kennelmanagercompose.versioncontrol.domain.models

import com.example.kennelmanagercompose.core.domain.interfaces.Entity
import java.util.UUID

/**
 * A "Git-style" commit containing many changes
 */
data class KennelCommit(
    override val id: String = UUID.randomUUID().toString(),
    val changes : List<KennelChangeRequest>,
    val requestedBy : String
): Entity
