package com.udacity.asteroidradar.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.api.AsteroidService
import com.udacity.asteroidradar.database.AsteroidDatabase
import com.udacity.asteroidradar.repository.AsteroidRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: AsteroidRepository
    val asteroids: LiveData<List<Asteroid>>

    init {
        val asteroidDao = AsteroidDatabase.getDatabase(application).asteroidDao()
        repository = AsteroidRepository(asteroidDao)
        asteroids = repository.asteroids

        // Fetch the asteroids
        fetchAsteroids()
    }

    private fun fetchAsteroids() = viewModelScope.launch {
        try {
            val asteroidsResponse = AsteroidService.service.getAsteroids()
            if (asteroidsResponse.isSuccessful) {
                asteroidsResponse.body()?.let { asteroids ->
                    // Save the fetched asteroids into the database
                    insertAll(asteroids)
                }
            } else {
                // Handle the error
            }
        } catch (e: Exception) {
            // Handle the exception
        }
    }

    fun insertAll(asteroids: List<Asteroid>) = viewModelScope.launch {
        repository.insertAll(asteroids)
    }
}