package com.example.harrypotter.data.repository

import com.example.harrypotter.data.api.HarryApi
import com.example.harrypotter.data.api.model.Character
import javax.inject.Inject

class HarryRepository @Inject constructor(
    private val harryApi: HarryApi
) {
    suspend fun getCharacters(): List<Character> {
        return harryApi.getCharacters()
    }
}