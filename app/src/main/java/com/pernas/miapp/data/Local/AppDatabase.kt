package com.pernas.miapp.data.Local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(MovieData::class), version = 1)
abstract class App2Database : RoomDatabase() {

    abstract fun moviesDao(): MoviefavoritesDao
}

object DatabaseFactory {
    fun get(context: Context): App2Database {
        return Room.databaseBuilder(context, App2Database::class.java, "app2_database").build()
    }
}