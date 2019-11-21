package com.pernas.miapp.ui.MovieDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.pernas.miapp.R
import com.pernas.miapp.data.Local.DatabaseFactory
import com.pernas.miapp.data.Local.MovieData
import com.pernas.miapp.model.MovieDetail
import com.pernas.miapp.model.genresList
import com.pernas.miapp.ui.Favorites.Favorites
import com.pernas.miapp.ui.Favorites.FavoritesPresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details_movie.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailActivity : AppCompatActivity(), MovieDetailPresenter.MovieDetailView {


    override fun sendFavorites(detailList: MovieDetail, myMovieId: Int) {
        favorites_icon.setOnClickListener {
            val database = DatabaseFactory.get(this)
            val moviesDao = database.moviesDao()
            CoroutineScope(Dispatchers.IO).launch {
                moviesDao.insert(
                    MovieData(
                        movie_id = myMovieId,
                        title = detailList.title,
                        year = detailList.release_date,
                        rating = detailList.vote_average
                    )
                )
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@MovieDetailActivity,
                        "Added to favorites! :)",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    override fun showMovieDetail(detailList: MovieDetail) {
        movieTitle.text = detailList.title
        movieDetailYear.text = detailList.release_date
        movieDetailDescription.text = detailList.overview
        movieDetailRating.text = detailList.vote_average
        val photo = "https://image.tmdb.org/t/p/w500" + detailList.backdrop_path
        Picasso.get().load(photo).placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground).into(imageViewMovie)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_details_movie)

        val movieId = intent.extras?.getInt("movie_id")
        val presenter = MovieDetailPresenter(this)
        presenter.fetchMovieDetail(movieId!!)
    }
}