package com.example.projetnav.ui.series.personnages

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Personnage(
    val name: String,
    val surname: String,
    val imageResId: Int
) : Parcelable