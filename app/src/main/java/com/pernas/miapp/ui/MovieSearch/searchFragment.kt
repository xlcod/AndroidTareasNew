package com.pernas.miapp.ui.MovieSearch


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pernas.miapp.R
import com.pernas.miapp.R.id.searchViewFragment
import com.pernas.miapp.data.RetrofitFactory
import com.pernas.miapp.model.MovieDataClass
import com.pernas.miapp.ui.MovieDetail.detailsMovieFragment
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.R
import android.R
import android.R
import kotlinx.android.synthetic.main.fragment_details_movie.view.*
import android.R
import android.R






/**
 * A simple [Fragment] subclass.
 */
class searchFragment : Fragment(), MovieSearchView {

    lateinit var si: RecyclerView

    lateinit var miSearch: SearchView

    lateinit var buscado: CharSequence

    lateinit var movieName: String

    override fun showCities(movies: List<MovieDataClass>) {

        citiesAdapter.addCities(movies)
        MoviesRecyclerView.visibility = View.VISIBLE
        //emptyView.visibility = View.GONE
    }

    override fun openMovieDetail(id: Int) {
        val intent = Intent(getActivity(), detailsMovieFragment::class.java)
        //intent.putExtra("city_id")
        val newGamefragment = GameSettingsFragment()
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(
            com.pernas.miapp.R.id.content_frame,
            someFragment(com.pernas.miapp.R.id.details_frament)
        ) // give your fragment container id in first parameter
        transaction.addToBackStack(null)  // if written, this transaction will be added to backstack
        transaction.commit()



    }

    

    override fun showError() {

    }

    override fun showEmpty() {

    }

    lateinit var citiesAdapter: CitiesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_search, container, false)

        miSearch = view.findViewById(R.id.searchViewFragment)

        miSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    movieName = query
                }
                val weatherApi = RetrofitFactory.getWeatherApi()
                CoroutineScope(Dispatchers.IO).launch {
                    val response =
                        weatherApi.searchCities("77335f53286ea3ce074ab21558a8fd05", movieName)
                    withContext(Dispatchers.Main) {
                        citiesAdapter.addCities(response.body()?.results!!)
                    }
                }
                return false
            }

        })

        si = view.findViewById(R.id.MoviesRecyclerView)

        val presenter = MovieSearchPresenter(this)

        si.layoutManager = LinearLayoutManager(this.context)
        si.setHasFixedSize(true)
        citiesAdapter = CitiesAdapter {
            presenter.cityClicked(it)
        }
        si.adapter = citiesAdapter

        return view
    }


}













