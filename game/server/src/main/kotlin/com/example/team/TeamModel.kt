package com.example.team

import com.example.util.Identifier


data class Team(
    val id: Identifier,
    var points: Int = 0,
) {
    val name: String = "Team#${id + 1}"
}
