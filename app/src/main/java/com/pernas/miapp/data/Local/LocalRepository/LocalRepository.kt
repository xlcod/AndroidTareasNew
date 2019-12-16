package com.pernas.miapp.data.Local.LocalRepository

import com.pernas.miapp.data.Local.MovieData


interface LocalRepository {
    suspend fun updatefavorites():List<MovieData>
    suspend fun insertMovies(movies: MovieData)
    suspend fun deletedatabase()

}