package com.example.results

import com.example.team.Team
import org.springframework.stereotype.Service

typealias GameResult = List<Team>

@Service
class GameResultsService {
    companion object {
        val gameHistory = mutableListOf<GameResult>()
    }
}