package com.example.kennelmanagercompose.domain.interfaces

import com.example.kennelmanagercompose.domain.models.housing.Cage

interface KennelAdminService {
    fun requestCageAddition(cage: Cage)
    fun requestCageRemoval(cageId: String)
    fun requestCageUpdate(cage: Cage)


}