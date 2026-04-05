package com.example.kennelmanagercompose.dog.poop.domain.models

enum class PoopScore(
    val score: Int,
    val displayName: String,
    val description: String
){
    HARD(1, "Hard", "Very hard/dry; pellets; leaves no residue."),
    FIRM(2, "Firm", "Firm but not hard; leaves little/no residue."),
    LOG(3, "Log", "Log-shaped; moist surface; leaves residue."),
    SOGGY(4, "Soggy", "Very moist; distinct log shape; sags when picked up."),
    MOIST(5, "Moist", "Very moist; has shape but piles up when expelled."),
    THIN(6, "Thin", "Texture but no defined shape; spots or piles."),
    WATERY(7, "Watery", "Watery; no texture; flat puddles.");
}