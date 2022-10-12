package com.codepath.BitFit

import android.os.Parcelable
import kotlinx.parcelize.Parcelize



@Parcelize
data class Food1(
    val name: String? = "",
    val calories: Double?
) : Parcelable