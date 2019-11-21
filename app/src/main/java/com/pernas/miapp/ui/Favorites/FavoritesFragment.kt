package com.pernas.miapp.ui.Favorites


import android.content.Intent
import android.os.Bundle
import android.util.Log

import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import com.pernas.miapp.data.Local.DatabaseFactory
import com.pernas.miapp.data.Local.MovieData
import com.pernas.miapp.ui.Profile.FavoritesAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.view.MenuInflater
import com.pernas.miapp.model.MovieDataClass
import com.pernas.miapp.ui.MovieDetail.MovieDetailActivity
import com.pernas.miapp.ui.MovieSearch.MoviesAdapter


/**
 * A simple [Fragment] subclass.
 */
class FavoritesFragment : Fragment(), Favorites {
    override fun openMovieDetail(id: Int) {
        val intent = Intent(this.context, MovieDetailActivity::class.java)
        intent.putExtra("movie_id", id)
        startActivity(intent)
    }

    lateinit var favoritesAdapter: FavoritesAdapter
    lateinit var myRecyclerView: RecyclerView

    override fun showMyFavorites(listFav: List<MovieData>) {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                favoritesAdapter.addMyFavorites(listFav)

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(com.pernas.miapp.R.menu.menu_favorites, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            com.pernas.miapp.R.id.deleteItem -> {
                Toast.makeText(this.context, "click en delete", Toast.LENGTH_LONG).show()
                val myDatabase = DatabaseFactory.get(this.context!!)
                val moviesDao = myDatabase.moviesDao()
                val presenter = FavoritesPresenter(this)
                presenter.deleteDatabase(moviesDao)
                favoritesAdapter.notifyDelete()

                true
            }
            com.pernas.miapp.R.id.orderItem -> {
                Toast.makeText(this.context, "click en orden", Toast.LENGTH_LONG).show()
                return true
            }
            com.pernas.miapp.R.id.subordenar -> {
                val presenter = FavoritesPresenter(this)
                val myDatabase = DatabaseFactory.get(this.context!!)
                val moviesDao = myDatabase.moviesDao()

                presenter.orderFavorites(moviesDao)
                return true
            }
            com.pernas.miapp.R.id.subordenar2 -> {
                Toast.makeText(this.context, "click en orden", Toast.LENGTH_LONG).show()
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        val view = inflater.inflate(com.pernas.miapp.R.layout.fragment_favorites, container, false)

        myRecyclerView = view.findViewById(com.pernas.miapp.R.id.favoritesRecyclerView)

        val presenter = FavoritesPresenter(this)

        myRecyclerView.layoutManager = LinearLayoutManager(this.context)
        myRecyclerView.setHasFixedSize(true)
        favoritesAdapter = FavoritesAdapter {
            presenter.movieClicked(it)
        }
        myRecyclerView.adapter = favoritesAdapter

        val myDatabase = DatabaseFactory.get(this.context!!)
        val moviesDao = myDatabase.moviesDao()
        presenter.updateFavorites(moviesDao)


        fun checkFavorites() {
            CoroutineScope(Dispatchers.IO).launch {
                presenter.checkFavorites(moviesDao)

            }
        }






        return view


    }
}


