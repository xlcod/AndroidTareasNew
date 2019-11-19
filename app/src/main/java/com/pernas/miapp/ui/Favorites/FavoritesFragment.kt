package com.pernas.miapp.ui.Favorites


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pernas.miapp.R
import com.pernas.miapp.ui.MovieDetail.MovieDetailActivity
import com.pernas.miapp.ui.MovieSearch.MovieSearchPresenter
import com.pernas.miapp.ui.MovieSearch.MoviesAdapter
import com.pernas.miapp.ui.Profile.FavoritesAdapter

/**
 * A simple [Fragment] subclass.
 */
class FavoritesFragment : Fragment(), FavoritesPresenter.Favorites {
    lateinit var favoritesAdapter: FavoritesAdapter

    lateinit var myRecyclerView: RecyclerView

    override fun openMovieDetail() {
       /* val intent = Intent(this.context, MovieDetailActivity::class.java)
        //intent.putExtra("movie_id", id)
        startActivity(intent)*/
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favorites, container, false)

        myRecyclerView = view.findViewById(R.id.favoritesRecyclerView)

        val presenter = FavoritesPresenter(this)

        myRecyclerView.layoutManager = LinearLayoutManager(this.context)
        myRecyclerView.setHasFixedSize(true)
        favoritesAdapter = FavoritesAdapter()
        myRecyclerView.adapter = favoritesAdapter






        return view
    }
}
