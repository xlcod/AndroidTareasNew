package com.pernas.miapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {


    private lateinit var nameRider: TextView
    private lateinit var birthDate: TextView
    private lateinit var city: TextView
    private lateinit var riderImage: ImageView
    private lateinit var description: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        nameRider = findViewById(R.id.nameRider)
        birthDate = findViewById(R.id.BirthDate)
        city = findViewById(R.id.city)
        riderImage = findViewById(R.id.riderImage)
        description = findViewById(R.id.descriptionContent)


        var intent = intent

        var name_rider = intent.extras?.getString("riderName")
        var birth_date = intent.extras?.getString("birth_date")
        var cityName = intent.extras?.getString("city")
        var profileImage = intent.getIntExtra("image", 1)
        var descriptionCont = intent.extras?.getString("description")

        nameRider.text = name_rider
        birthDate.text = birth_date
        city.text = cityName
        description.text = descriptionCont
        riderImage.setImageResource(profileImage)


    }
}
