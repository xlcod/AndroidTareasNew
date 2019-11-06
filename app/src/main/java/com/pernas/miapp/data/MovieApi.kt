package com.pernas.miapp.data


import com.pernas.miapp.model.Movie
import com.pernas.miapp.model.MovieDataClass
import com.pernas.miapp.model.MoviesDetailReponse
import com.pernas.miapp.model.movieResults
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieApi {

    //query serach
    @GET("search/movie/")
    suspend fun searchCities(@Query("api_key") term: String,@Query("query") term2: String): Response<movieResults>

    //query details
    //https://api.themoviedb.org/3/movie/5?api_key=77335f53286ea3ce074ab21558a8fd05
    @GET("movie/{movieId}")
    suspend fun getCityDetail(@Path("movieId") movieId: Int, @Query("api_key") term2: String): Response<MoviesDetailReponse>

}


object RetrofitFactory {
    const val BASE_URL = "https://api.themoviedb.org/3/"

    fun getWeatherApi(): MovieApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(MovieApi::class.java)
    }
}