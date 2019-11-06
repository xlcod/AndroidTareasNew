package com.pernas.miapp.ui.MovieDetail

import com.pernas.miapp.data.RetrofitFactory
import com.pernas.miapp.model.MovieDetail
import com.pernas.miapp.model.movieResults
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MovieDetailPresenter (val view: MovieDetailView) {

    fun fetchCityDetail(cityId: Int) {
        val weatherApi = RetrofitFactory.getWeatherApi()
        CoroutineScope(Dispatchers.IO).launch {
            val response = weatherApi.getCityDetail(cityId)
            withContext(Dispatchers.Main) {
                view.showWeatherDetail(response.body()!!.moviesDetailReponse)
            }
        }
    }
    interface MovieDetailView {
        fun showWeatherDetail(detail: List<MovieDetail>)
    }




}