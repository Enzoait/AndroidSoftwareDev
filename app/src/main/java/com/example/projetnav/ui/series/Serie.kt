package com.example.projetnav.ui.series

import android.os.Parcelable
import com.example.projetnav.ui.series.episodes.Episode
import com.example.projetnav.ui.series.personnages.Personnage
import kotlinx.parcelize.Parcelize

@Parcelize
data class Serie(
    val title: String,
    val imageResId: Int,
    val studio: String,
    val numberOfEpisodes: Int,
    val year: Int,
    val story: String,
    val personnages: List<Personnage>,
    val episodes: List<Episode>
) : Parcelable