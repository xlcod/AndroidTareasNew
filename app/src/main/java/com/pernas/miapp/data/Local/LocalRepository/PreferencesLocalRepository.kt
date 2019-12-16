package com.pernas.miapp.data.Local.LocalRepository

import android.content.SharedPreferences
import android.util.Log
import com.pernas.miapp.data.Local.MovieData
import com.pernas.miapp.data.Local.MoviefavoritesDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PreferencesLocalRepository(dao : MoviefavoritesDao) : LocalRepository{
    lateinit var myDao : MoviefavoritesDao
    override suspend fun updatefavorites(): List<MovieData> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun insertMovies(movies: MovieData) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deletedatabase() {
        CoroutineScope(Dispatchers.IO).launch {
            myDao.deleteTable()
        }




    }


}