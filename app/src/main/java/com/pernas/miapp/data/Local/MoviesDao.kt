package com.pernas.miapp.data.Local

import androidx.room.Dao
import androidx.room.Ignore
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MoviefavoritesDao {

    @Query("SELECT * FROM  MovieData ORDER BY :order ASC")
    suspend fun getAll(order: String ): List<MovieData>

    @Insert
    suspend fun insert(movies: MovieData)

    @Query("DELETE FROM MovieData")
    suspend fun deleteTable()




}