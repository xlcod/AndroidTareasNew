package com.pernas.miapp.ui.MovieSearch

import com.pernas.miapp.data.RetrofitFactory
import com.pernas.miapp.model.MovieDataClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieSearchPresenter(val view: MovieSearchView) {

    fun searchClicked(searchTerm: String) {
        if (searchTerm.isEmpty()) return

        val weatherApi = RetrofitFactory.getWeatherApi()
        CoroutineScope(Dispatchers.IO).launch {
            val response =
                weatherApi.searchCities("77335f53286ea3ce074ab21558a8fd05", "Scary Movie")
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val movies = response.body()!!
                    if (movies.isEmpty()) {
                        view.showEmpty()
                        return@withContext
                    }
                    view.showCities(response.body()!!)
                } else {
                    view.showError()
                }
            }
        }
    }

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