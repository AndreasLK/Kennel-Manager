package com.example.kennelmanagercompose.domain.models.events.extenions

import com.example.kennelmanagercompose.domain.models.events.HousingLog
import java.time.Instant

fun HousingLog.overlaps(start: Instant, end: Instant): Boolean {
    return this.movedInAt < end && (this.movedOutAt == null || this.movedOutAt!! > start)
}

fun HousingLog.wasDogInCageAt(targetCageId: String?, time: Instant): Boolean {
    if (targetCageId == null || targetCageId != this.cageId) return false
    return time >= this.movedInAt && (this.movedOutAt == null || time <= this.movedOutAt!!)
}