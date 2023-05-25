package com.udacity.asteroidradar.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.Constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface AsteroidApiService {
    @GET("your_endpoint_here")  // Define your endpoint here
    suspend fun getAsteroids(): Response<List<Asteroid>>
}

object AsteroidService {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val service: AsteroidApiService by lazy {
        retrofit.create(AsteroidApiService::class.java)
    }
}