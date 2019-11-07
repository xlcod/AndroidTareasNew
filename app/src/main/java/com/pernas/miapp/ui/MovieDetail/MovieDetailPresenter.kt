package com.pernas.miapp.ui.MovieDetail

import android.util.Log
import com.pernas.miapp.data.RetrofitFactory
import com.pernas.miapp.model.MovieDetail
import com.pernas.miapp.model.MoviesDetailReponse
import com.pernas.miapp.model.movieResults
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MovieDetailPresenter(val view: MovieDetailView) {

    fun fetchCityDetail(movieId: Int) {
        val weatherApi = RetrofitFactory.getWeatherApi()
        CoroutineScope(Dispatchers.IO).launch {
            val response = weatherApi.getCityDetail(movieId, "77335f53286ea3ce074ab21558a8fd05")
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val movies = response.body()!!

                    view.showMovieDetail(response.body()!!)
                } else {

                }
            }
        }
    }

    interface MovieDetailView {
        fun showMovieDetail(detailList: MovieDetail)
    }
}