package com.pernas.miapp.model

data class movieResults(

    val results: List<MovieDataClass>
)


data class MoviesDetailReponse(
    val moviesDetailResponse: List<MovieDetail>
)
data class genresList(
    val name: String
)


data class MovieDetail(
    val title: String,
    val vote_average: String,
    val overview: String,
    val release_date: String,
    val backdrop_path: String,
    val genres: List<genresList>
)

