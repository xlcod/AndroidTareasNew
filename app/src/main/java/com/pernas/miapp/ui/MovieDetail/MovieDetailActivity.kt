package com.pernas.miapp.ui.MovieDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pernas.miapp.R
import com.pernas.miapp.data.RetrofitFactory
import com.pernas.miapp.model.MovieDetail
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details_movie.*

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.log

class MovieDetailActivity : AppCompatActivity(), MovieDetailPresenter.MovieDetailView {
    override fun showMovieDetail(detailList: MovieDetail) {
        Log.e("Pasado", detailList.toString())

        movieTitle.text = detailList.title
        movieDetailYear.text = detailList.release_date
        movieDetailDescription.text = detailList.overview
        movieDetailRating.text = detailList.vote_average
        //movieDetailGenre(detailList.genres.map { it.name })
        val photo = "https://image.tmdb.org/t/p/w500" + detailList.backdrop_path
        Picasso.get().load(photo).placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground).into(imageViewMovie)


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_details_movie)

        val MovieId = intent.extras?.getInt("movie_id")
        val presenter = MovieDetailPresenter(this)
        presenter.fetchCityDetail(MovieId!!)

    }

    fun movieDetailGenre(detailList: MovieDetail, pasado: String) {
        //movieDetailGenre.text=detailList.genres
    }
}