package com.example.kennelmanagercompose.domain.enums


enum class BodyScore {
    VERY_THIN,
    THIN,
    IDEAL,
    THICK,
    OBESE,
    UNKNOWN;

    companion object { //Basically makes the fromInt function "Static"
        fun fromInt(score: Int?) : BodyScore {
            return when (score) {
                1, 2    -> VERY_THIN
                3       -> THIN
                4, 5, 6 -> IDEAL
                7       -> THICK
                8, 9    -> OBESE
                else    -> UNKNOWN
            }
        }
    }
}