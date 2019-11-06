package com.pernas.miapp.ui.Profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.pernas.miapp.R


/**
 * A simple [Fragment] subclass.
 */
class profileFragment : Fragment() {
    private lateinit var nameRider: TextView
    private lateinit var birthDate: TextView
    private lateinit var city: TextView
    private lateinit var riderImage: ImageView
    private lateinit var description: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        nameRider = view.findViewById(R.id.nameRider) as TextView
        birthDate = view.findViewById(R.id.BirthDate) as TextView
        city = view!!.findViewById(R.id.city) as TextView
        riderImage = view!!.findViewById(R.id.riderImage) as ImageView
        description = view!!.findViewById(R.id.descriptionContent) as TextView


        var name_rider = "Brandom semenuk"
        var birth_date = "15/15/92"
        var cityName = "Alberta"
        var profileImage = R.drawable.foto
        var descriptionCont =
            "Brandon Semenuk is a Canadian freeride mountain biker from Whistler," +
                    " British Columbia. Semenuk is a 3-time FMB World Tour Gold Medalist. He is a 2013 " +
                    "Munich X-Games Silver medalist in the Mountain Bike Slopestyle event, a 2008, 2016 and 2019 " +
                    "Red Bull Rampage winner, 2nd person who won rampage three-times. "

        nameRider.text = name_rider
        birthDate.text = birth_date
        city.text = cityName
        description.text = descriptionCont
        riderImage.setImageResource(profileImage)
        // Inflate the layout for this fragment
        return view
    }


}
