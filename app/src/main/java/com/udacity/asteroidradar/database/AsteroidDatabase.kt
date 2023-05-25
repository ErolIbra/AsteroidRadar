package com.udacity.asteroidradar.database



import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.udacity.asteroidradar.Asteroid

@Database(entities = [Asteroid::class], version = 1)
abstract class AsteroidDatabase : RoomDatabase() {
    abstract fun asteroidDao(): AsteroidDao

    companion object {
        @Volatile
        private var INSTANCE: AsteroidDatabase? = null

        fun getDatabase(context: Context): AsteroidDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AsteroidDatabase::class.java,
                    "asteroids_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}


/*
@Database(entities = [Asteroid::class], version = 1)
abstract class AsteroidDatabase : RoomDatabase() {
    abstract fun asteroidDao(): AsteroidDao

    val db = Room.databaseBuilder(
        applicationContext,
        AsteroidDatabase::class.java, "asteroids-db"
    ).build()
    val asteroidDao = db.asteroidDao()
}

 */

/*
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.udacity.asteroidradar.Asteroid

@Database(entities = [Asteroid::class], version = 1/* exportSchema = false */)
abstract class AsteroidDatabase : RoomDatabase() {

    abstract fun asteroidDao(): AsteroidDao

    companion object {
        @Volatile
        private var INSTANCE: AsteroidDatabase? = null

        fun getDatabase(context: Context): AsteroidDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AsteroidDatabase::class.java,
                    "asteroid_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

 */