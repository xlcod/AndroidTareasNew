package com.pernas.miapp.ui.Favorites

import android.util.Log
import com.pernas.miapp.data.Local.MovieData
import com.pernas.miapp.data.Local.MoviefavoritesDao
import com.pernas.miapp.model.MovieDataClass
import com.pernas.miapp.ui.MovieDetail.MovieDetailActivity
import com.pernas.miapp.ui.MovieSearch.MovieSearchView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoritesPresenter(val view: Favorites) {
    fun updateFavorites(dao: MoviefavoritesDao) {
        CoroutineScope(Dispatchers.IO).launch {
            val title = dao.getAll("Title")
            Log.e("prueba", "$title")
            withContext(Dispatchers.Main) {
                view.showMyFavorites(title)
            }
        }
    }

    fun deleteDatabase(dao: MoviefavoritesDao) {
        CoroutineScope(Dispatchers.IO).launch {
            val title = dao.deleteTable()
            Log.e("prueba", "$title")
        }
    }

    fun movieClicked(favorites: MovieData) {
        favorites.movie_id?.let { view.openMovieDetail(it) }
    }
    fun checkFavorites( myDataCheck: MoviefavoritesDao) {
    }
    fun orderFavorites(dao: MoviefavoritesDao) {
        CoroutineScope(Dispatchers.IO).launch {
             dao.getAll("Title")
        }
    }
}


interface Favorites {
    fun showMyFavorites(listFav: List<MovieData>)
    fun openMovieDetail(id: Int)
}

