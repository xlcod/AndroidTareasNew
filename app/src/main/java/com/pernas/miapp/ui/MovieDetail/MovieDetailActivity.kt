package com.pernas.miapp.ui.MovieDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pernas.miapp.R
import com.pernas.miapp.data.RetrofitFactory
import com.pernas.miapp.model.MovieDetail

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.log

class MovieDetailActivity : AppCompatActivity(), MovieDetailPresenter.MovieDetailView {
    override fun showMovieDetail(detail: List<MovieDetail>) {
        Log.e("Pasado", detail.toString())

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_details_movie)

        val MovieId = intent.extras?.getInt("movie_id")

        Log.e("id_recibido", "$MovieId")


        val presenter = MovieDetailPresenter(this)
        presenter.fetchCityDetail(MovieId!!)


        val weatherApi = RetrofitFactory.getWeatherApi()
        /*CoroutineScope(Dispatchers.IO).launch {
            val response =
                weatherApi.getCityDetail(MovieId, "77335f53286ea3ce074ab21558a8fd05")
            withContext(Dispatchers.Main) {
                response.body()?.moviesDetailResponse!!
            }
        }*/


    }
}
