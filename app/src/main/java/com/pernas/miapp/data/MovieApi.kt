package com.pernas.miapp.data


import com.pernas.miapp.model.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieApi {

    //query search
    @GET("search/movie/")
    suspend fun searchCities(@Query("api_key") term: String, @Query("query") term2: String): Response<movieResults>

    //query details
    @GET("movie/{movieId}")
    suspend fun getCityDetail(@Path("movieId") movieId: Int, @Query("api_key") term2: String): Response<MovieDetail>

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