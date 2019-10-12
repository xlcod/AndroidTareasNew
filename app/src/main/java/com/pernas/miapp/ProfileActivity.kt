package com.pernas.miapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {


    private lateinit  var nameRider: TextView
    private lateinit  var birthDate: TextView
    private lateinit  var city: TextView
    private lateinit  var riderImage: ImageView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
       //val name =  intent.extras?.getString("name")

        nameRider = findViewById(R.id.nameRider)
        birthDate = findViewById(R.id.BirthDate)
        city = findViewById(R.id.city)
        riderImage = findViewById(R.id.riderImage)

        var intent = intent

        var name_rider = intent.extras?.getString("riderName")
        var birth_date = intent.extras?.getString("birth_date")
        var cityName = intent.extras?.getString("city")
        var profileImage = intent.getIntExtra("image",1)

        nameRider.text = name_rider
        birthDate.text = birth_date
        city.text = cityName
        riderImage.setImageResource(profileImage)










    }
}
