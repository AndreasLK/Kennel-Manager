package com.example.kennelmanagercompose.dog.session.domain.enums

import com.example.kennelmanagercompose.core.AppConfig

enum class RunStatus {
    CANT_RUN,
    SHOULDNT_RUN,
    CAN_RUN,
    SHOULD_RUN,
    NEEDS_TO_RUN;

    companion object{
        fun fromInt (points: Int) : RunStatus {
            return when {
                points <= AppConfig.DEFAULT_SCORE_CANT_RUN -> CANT_RUN
                points <= AppConfig.DEFAULT_SCORE_SHOULDNT_RUN -> SHOULDNT_RUN
                points <= AppConfig.DEFAULT_SCORE_CAN_RUN -> CAN_RUN
                points <= AppConfig.DEFAULT_SCORE_SHOULD_RUN -> SHOULD_RUN
                else -> NEEDS_TO_RUN
            }
        }
    }
}