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






