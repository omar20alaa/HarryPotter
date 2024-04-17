package com.example.harrypotter.di

import com.example.harrypotter.data.api.ApiConstants
import com.example.harrypotter.data.api.HarryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CharacterApiModule {

    @Provides
    @Singleton
    fun provideApi(builder:Retrofit.Builder): HarryApi{
        return builder
            .build()
            .create(HarryApi::class.java)

    }

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }
}