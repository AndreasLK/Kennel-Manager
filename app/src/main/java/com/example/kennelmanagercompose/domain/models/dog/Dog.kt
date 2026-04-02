package com.example.kennelmanagercompose.domain.models.dog

import com.example.kennelmanagercompose.core.Entity
import com.example.kennelmanagercompose.domain.enums.BodyScore
import com.example.kennelmanagercompose.domain.enums.DogStatus
import com.example.kennelmanagercompose.domain.enums.Gender
import com.example.kennelmanagercompose.runtracking.domain.config.DogWorkOverrides
import java.time.Instant
import java.util.UUID

data class Dog(
    override val id: String = UUID.randomUUID().toString(),
    val name: String,
    val leadRating: Int, //0-5 Higher means better as lead dog
    val breed: String,
    val gender: Gender,
    val isCastrated: Boolean,
    val birthday: Instant,
    val bodyScore: BodyScore,
    val status: DogStatus,
    val tags: List<String> = emptyList(), //List of DogTag Ids that apply to dog
    val birthLitterId: String, //LitterID of the dog's birth litter. can be used to find parents or siblings
    val childLitterIds: List<String> = emptyList(),  //LitterIDs of the dog's litter. can be used to children of the dog
    val hates: List<String> = emptyList(), //List of dog IDs that dog hates
    val workOverrides: DogWorkOverrides = DogWorkOverrides()
) : Entity