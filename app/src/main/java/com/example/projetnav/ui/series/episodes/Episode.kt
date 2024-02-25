package com.example.projetnav.ui.series.episodes

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Episode(
    val title: String,
    val description: String,
    val episodeNumber: Int,
    val releaseDate: String
) : Parcelable