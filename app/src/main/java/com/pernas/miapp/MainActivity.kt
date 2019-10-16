package com.pernas.miapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var profileButton: Button
    private lateinit var button: Button
    private lateinit var myTextView: TextView
    private lateinit var movieButton: Button
    private lateinit var message: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button = findViewById<Button>(R.id.myButton)
        myTextView = findViewById<TextView>(R.id.textView)
        profileButton = findViewById(R.id.myProfile)
        movieButton = findViewById<Button>(R.id.myMovies)
        var sum = 0

        profileButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("riderName", "Brandom semenuk")
            intent.putExtra("birth_date", " 15/15/92")
            intent.putExtra("city", "Alberta")
            intent.putExtra("image", R.drawable.foto)
            intent.putExtra(
                "description",
                "Brandon Semenuk is a Canadian freeride mountain biker from Whistler, British Columbia." +
                        " Semenuk is a 3-time FMB World Tour Gold Medalist. He is a 2013 Munich X-Games Silver" +
                        " medalist in the Mountain Bike Slopestyle event," +
                        " a 2008 and 2016 Red Bull Rampage winner and a 5-time Red Bull Joyride winner." +
                        " He is known as one of the best freeride mountain bikers in history."
            )

            startActivity(intent)

        }

        movieButton.setOnClickListener {
            val intent = Intent(this, MovieDetailActivity::class.java)
            /*intent.putExtra("title","Revel in the chaos")
            intent.putExtra("genre", "Sports")
            intent.putExtra("date", "2016")
            intent.putExtra("rating", "8.3")
            intent.putExtra("description", "Lorem Ipsum \"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet," +
                    " consectetur, adipisci velit...\" \"There is no one who loves pain itself, who seeks after it and wants to have it," +
                    " simply because it is pain...\"   Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec et velit posuere," +
                    " tempus velit id, ultricies orci. Quisque ullamcorper consectetur est eget dictum. Suspendisse" +
                    " semper mi ac erat faucibus, vitae congue ante malesuada. " +
                    "Integer sagittis eu odio a fringilla. ")*/
            startActivity(intent)
        }




//val movvies  = listof<movies> {
       // movie()







        button.setOnClickListener() {
            sum += 1
             message = getString(R.string.button_pressed, sum, sum)
            myTextView.setText("""$message  $sum veces""")//concadeno la variable que va sumando
            //myTextView.text= message
        }
    }


    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {

        outState.putString("textView",message)

        super.onSaveInstanceState(outState, outPersistentState)


    }




    override fun onStart() {
        super.onStart()
       Log.e("main activity","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("main activity","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("main activity","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("main activity","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("main activity","onDestroy")
    }
}






