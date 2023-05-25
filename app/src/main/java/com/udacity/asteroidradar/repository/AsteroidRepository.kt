package com.udacity.asteroidradar.repository

import androidx.lifecycle.LiveData
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.database.AsteroidDao

class AsteroidRepository(private val asteroidDao: AsteroidDao) {
    val asteroids: LiveData<List<Asteroid>> = asteroidDao.getAll()

    val pictureOfDay: LiveData<List<Asteroid>> =

    suspend fun insertAll(asteroids: List<Asteroid>) {
        asteroidDao.insertAll(asteroids)
    }
}