package com.example.kennelmanagercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kennelmanagercompose.domain.enums.*
import com.example.kennelmanagercompose.domain.interfaces.KennelStateProvider
import com.example.kennelmanagercompose.domain.models.dog.Dog
import com.example.kennelmanagercompose.domain.models.housing.Cage
import com.example.kennelmanagercompose.heattracking.domain.models.Heat
import com.example.kennelmanagercompose.pooptracking.domain.models.PoopScore
import com.example.kennelmanagercompose.ui.WorkspaceViewModel
import com.example.kennelmanagercompose.ui.screens.KennelWorkspaceScreen
import java.time.Instant

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val stateProvider = object : KennelStateProvider {
            override fun getMissedMeals(dogId: String) = if(dogId == "dog1") MissedMeals.MISSED_4 else MissedMeals.DID_EAT
            override fun getLatestPoopScore(dogId: String) = if(dogId == "dog1" || dogId == "dog4") PoopScore.FIRM else PoopScore.WATERY
            override fun getHeatStatus(dogId: String) = if(dogId == "dog1" || dogId == "dog3" || dogId == "dog5") Heat.NOT_IN_HEAT else Heat.STANDING_HEAT
            override fun getMedicalStatus(dogId: String) = Severity.UNKNOWN
            override fun getBodyScore(dogId: String) = if(dogId == "dog1") BodyScore.THICK else BodyScore.IDEAL
            override fun getRunStatus(dogId: String) = RunStatus.CAN_RUN
            override fun getVaccineStatus(dogId: String) = Severity.LOW
        }

        setContent {
            val vm: WorkspaceViewModel = viewModel()

            // Load Test Windows
            LaunchedEffect(Unit) {
                val testDogs = listOf(
                    Dog(id = "dog1", name = "Buddy", breed = "Husky", leadRating = 5, gender = Gender.MALE, isCastrated = true, birthday = Instant.now(), bodyScore = BodyScore.IDEAL, status = DogStatus.ACTIVE, birthLitterId = "L1"),
                    Dog(id = "dog2", name = "Luna", breed = "Malamute", leadRating = 3, gender = Gender.FEMALE, isCastrated = false, birthday = Instant.now(), bodyScore = BodyScore.THIN, status = DogStatus.ACTIVE, birthLitterId = "L1"),

                    // The 5-Dog Pack
                    Dog(id = "dog3", name = "Max", breed = "Husky", leadRating = 4, gender = Gender.MALE, isCastrated = true, birthday = Instant.now(), bodyScore = BodyScore.OBESE, status = DogStatus.ACTIVE, birthLitterId = "L2"),
                    Dog(id = "dog4", name = "Bella", breed = "Husky", leadRating = 2, gender = Gender.FEMALE, isCastrated = false, birthday = Instant.now(), bodyScore = BodyScore.IDEAL, status = DogStatus.ACTIVE, birthLitterId = "L2"),
                    Dog(id = "dog5", name = "Charlie", breed = "Malamute", leadRating = 5, gender = Gender.MALE, isCastrated = true, birthday = Instant.now(), bodyScore = BodyScore.IDEAL, status = DogStatus.ACTIVE, birthLitterId = "L3"),
                    Dog(id = "dog6", name = "Zeus", breed = "Husky", leadRating = 4, gender = Gender.MALE, isCastrated = false, birthday = Instant.now(), bodyScore = BodyScore.THIN, status = DogStatus.ACTIVE, birthLitterId = "L3"),
                )

                val testCages = listOf(
                    Cage(
                        id = "1", rowName = "A1", maxCapacity = 2, mapX = 100f, mapY = 100f,
                        dogsInside = listOf("dog1", "dog2"), longitude = 0.0, latitude = 0.0, description = ""
                    ),
                    Cage(
                        id = "2", rowName = "Main Run", maxCapacity = 5, mapX = 500f, mapY = 200f,
                        scaleX = 1.5f, scaleY = 1.5f, // Made this window slightly larger
                        dogsInside = listOf("dog3", "dog4", "dog5", "dog6"),
                        longitude = 0.0, latitude = 0.0, description = ""
                    )
                )
                // Ensure your loadKennelMap accepts (List<Cage>, List<Dog>)
                vm.loadKennelMap(testCages, testDogs)
            }

            KennelWorkspaceScreen(vm = vm, provider = stateProvider)
        }
    }
}