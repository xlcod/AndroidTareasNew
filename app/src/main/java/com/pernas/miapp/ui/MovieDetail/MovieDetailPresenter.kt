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

    fun fetchMovieDetail(movieId: Int) {
        val movieDbApi = RetrofitFactory.getMovieDbApi()
        CoroutineScope(Dispatchers.IO).launch {
            val response = movieDbApi.getMovieDetail(movieId, "77335f53286ea3ce074ab21558a8fd05")
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    view.showMovieDetail(response.body()!!)
                    view.sendFavorites(response.body()!!,movieId)
                } else {
                    Log.e("MovieDetailPresenter","Call failed")
                }
            }
        }
    }

    interface MovieDetailView {
        fun showMovieDetail(detailList: MovieDetail)
        fun sendFavorites(detailList: MovieDetail,movieid: Int)
    }
}