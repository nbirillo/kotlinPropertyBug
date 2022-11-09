package com.example.team

import com.example.util.Identifier
import com.example.util.IdentifierFactory
import org.springframework.stereotype.Service

@Service
class TeamService {
    companion object {
        val teamsStorage = mutableMapOf<Identifier, Team>()
    }

    private val identifierFactory = IdentifierFactory()
}
