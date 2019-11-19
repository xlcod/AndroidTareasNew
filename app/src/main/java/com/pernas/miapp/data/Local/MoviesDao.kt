package com.pernas.miapp.data.Local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MoviefavoritesDao {

    @Query("SELECT * FROM  MovieData")
    suspend fun getAll(): List<MovieData>

    @Insert
    suspend fun insert(movies: MovieData)

    @Query("DELETE FROM MovieData")
    suspend fun nukeTable()


}