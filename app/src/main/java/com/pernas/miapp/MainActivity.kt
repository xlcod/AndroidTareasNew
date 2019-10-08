package com.pernas.miapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.myButton)// pick the id
        var myTextView = findViewById<TextView>(R.id.textView) // pick the id
        var sum = 0



        button.setOnClickListener() {
            sum += 1
            myTextView.setText("""Has pulsado el boton  $sum veces""")//concadeno la variable que va sumando
        }
    }


}






