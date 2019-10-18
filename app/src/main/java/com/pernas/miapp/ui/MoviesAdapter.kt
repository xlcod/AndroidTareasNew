package com.pernas.miapp.ui

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(val stringsList: List<String>): RecyclerView.Adapter<StringListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringListViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return stringsList.size

    }

    override fun onBindViewHolder(holder: StringListViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}

class StringListViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView) {

}
