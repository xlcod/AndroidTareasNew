package com.pernas.miapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pernas.miapp.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*


class MovieDetailActivity : AppCompatActivity() {

    val movie = Movie(
        id = 1,
        title = "Revel in the chaos",
        year = "2016",
        genre = "Action",
        description = "Lorem Ipsum\n" +
                "\"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\"\n" +
                "\"There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain...\"\n" +
                "\n" +
                "\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec et velit posuere, tempus velit id, ultricies orci. Quisque ullamcorper consectetur est eget dictum. Suspendisse semper mi ac erat faucibus, vitae congue ante malesuada. Integer sagittis eu odio a fringilla. Vestibulum et odio risus. Proin at justo tincidunt, mattis mi vel, finibus dolor. ",
        rating = 7.5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        with(movie){
            movieTitle.text = title
            dateTitle.text = year
            idGenre.text = genre
            idDescription.text = description
            idRating.text = rating.toString()
        }
        Picasso.get().load("https://i.ytimg.com/vi/4Bvdp94K1uU/maxresdefault.jpg").into(imageView);
    }



    override fun onStart() {
        super.onStart()
        Log.e("MovieDetailActivity","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MovieDetailActivity","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MovieDetailActivity","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MovieDetailActivity","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MovieDetailActivity","onDestroy")
    }
}
