package com.pernas.miapp.ui.MovieSearch

import com.pernas.miapp.data.RetrofitFactory
import com.pernas.miapp.model.MovieDataClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieSearchPresenter(val view: MovieSearchView) {

    fun movieClicked(Movie: MovieDataClass) {
        view.openMovieDetail(Movie.id)
    }
}

interface MovieSearchView {
    fun showCities(movies: List<MovieDataClass>)
    fun openMovieDetail(id: Int)
    fun showError()
    fun showEmpty()
}
