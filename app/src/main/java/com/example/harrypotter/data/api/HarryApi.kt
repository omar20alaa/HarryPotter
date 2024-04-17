package com.example.harrypotter.data.api

import com.example.harrypotter.data.api.model.Character
import retrofit2.http.GET

interface HarryApi {

    @GET(ApiConstants.CHARACTER)
    suspend fun getCharacters() : List<Character>

}