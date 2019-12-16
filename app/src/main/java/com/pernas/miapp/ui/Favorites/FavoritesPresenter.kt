package com.pernas.miapp.ui.Favorites

import android.util.Log
import com.pernas.miapp.data.Local.LocalRepository.LocalRepository
import com.pernas.miapp.data.Local.MovieData
import com.pernas.miapp.data.Local.MoviefavoritesDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoritesPresenter(val view: Favorites) {

    fun updateFavorites(dao: MoviefavoritesDao) {
        CoroutineScope(Dispatchers.IO).launch {
            val title = dao.getAll("Title")
            withContext(Dispatchers.Main) {
                view.showMyFavorites(title)
            }
        }
    }

    fun deleteDatabase(dao: MoviefavoritesDao) {
        CoroutineScope(Dispatchers.IO).launch {
            val title = dao.deleteTable()
        }
    }

    fun movieClicked(favorites: MovieData) {
        favorites.movie_id?.let { view.openMovieDetail(it) }
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

