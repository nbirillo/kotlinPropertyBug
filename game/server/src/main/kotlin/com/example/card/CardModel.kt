package com.example.card

import com.example.util.Identifier

@JvmInline
value class Word(val word: String)

data class Card(
    val id: Identifier,
    val words: List<Word>
)
