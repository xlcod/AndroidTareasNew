package com.pernas.miapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var profileButton: Button
    private lateinit var button: Button
    private lateinit var myTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById<Button>(R.id.myButton)
        myTextView = findViewById<TextView>(R.id.textView)
        profileButton = findViewById(R.id.myProfile)
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
                        " Semenuk is a 3-time FMB World Tour Gold Medalist. He is a 2013 Munich X-Games Silver medalist in the Mountain Bike Slopestyle event," +
                        " a 2008 and 2016 Red Bull Rampage winner and a 5-time Red Bull Joyride winner." +
                        " He is known as one of the best freeride mountain bikers in history."
            )

            startActivity(intent)

        }
        button.setOnClickListener() {
            sum += 1
            var message = getString(R.string.button_pressed, sum, sum)
            myTextView.setText("""$message  $sum veces""")//concadeno la variable que va sumando
            //myTextView.text= message
        }
    }
}






