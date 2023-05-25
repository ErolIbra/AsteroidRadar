package com.udacity.asteroidradar.database


import androidx.lifecycle.LiveData
import androidx.room.*
import com.udacity.asteroidradar.Asteroid

@Dao
interface AsteroidDao {
    @Query("SELECT * FROM asteroids")
    fun getAll(): LiveData<List<Asteroid>>

    @Query("")

    @Insert
    fun insertAll(vararg asteroids: List<Asteroid>)
}



/*
@Dao
interface AsteroidDao {

    @Query("SELECT * FROM asteroids")
    fun getAll(): LiveData<List<Asteroid>>

    @Query("SELECT * FROM asteroids WHERE id = :id")
    fun getAsteroid(id: Long): LiveData<Asteroid>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(asteroids: List<Asteroid>)

    @Delete
    suspend fun delete(asteroid: Asteroid)



//    @Insert
//    fun insertAll(vararg asteroids: Asteroid)
}

 */
