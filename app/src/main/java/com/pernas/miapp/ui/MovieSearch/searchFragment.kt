package com.pernas.miapp.ui.MovieSearch


import android.content.Intent
import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.pernas.miapp.data.RetrofitFactory
import com.pernas.miapp.model.MovieDataClass
import com.pernas.miapp.ui.MovieDetail.MovieDetailActivity


import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass.
 */
class searchFragment : Fragment(), MovieSearchView {

    lateinit var myRecyclerView: RecyclerView

    lateinit var miSearch: SearchView

    lateinit var movieName: String

    override fun showCities(movies: List<MovieDataClass>) {

        moviesAdapter.addMovies(movies)
        MoviesRecyclerView.visibility = View.VISIBLE
    }

    override fun openMovieDetail(id: Int) {
        val intent = Intent(this.context, MovieDetailActivity::class.java)
        intent.putExtra("movie_id", id)
        startActivity(intent)
    }

    override fun showError() {
    }

    override fun showEmpty() {
    }

    lateinit var moviesAdapter: MoviesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(com.pernas.miapp.R.layout.fragment_search, container, false)

        miSearch = view.findViewById(com.pernas.miapp.R.id.searchViewFragment)

        miSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    movieName = query
                }
                val weatherApi = RetrofitFactory.getMovieDbApi()
                CoroutineScope(Dispatchers.IO).launch {
                    val response =
                        weatherApi.searchMovies("77335f53286ea3ce074ab21558a8fd05", movieName)
                    withContext(Dispatchers.Main) {
                        moviesAdapter.addMovies(response.body()?.results!!)
                    }
                }
                return false
            }

        })

        myRecyclerView = view.findViewById(com.pernas.miapp.R.id.MoviesRecyclerView)

        val presenter = MovieSearchPresenter(this)

        myRecyclerView.layoutManager = LinearLayoutManager(this.context)
        myRecyclerView.setHasFixedSize(true)
        moviesAdapter = MoviesAdapter {
            presenter.movieClicked(it)
        }
        myRecyclerView.adapter = moviesAdapter

        return view
    }
}