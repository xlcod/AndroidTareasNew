package com.pernas.miapp.data.Local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieData (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "movie_id") val movie_id: Int?,
    @ColumnInfo(name = "Title") val title: String?,
    @ColumnInfo(name = "year") val year: String?,
    @ColumnInfo(name = "rating") val rating: String?
)