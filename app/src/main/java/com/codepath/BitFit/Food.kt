package com.codepath.BitFit

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


class Food(
    val name: String?,
    val calories: Double?
)




/*
@Keep
@Serializable
data class BaseResponse(
    @SerialName("results")
    val results: List<Food>?
)

@Keep
@Serializable
data class Food(
    @SerialName("name")
    val title: String?,

    @SerialName("overview")
    val description: String?,

    @SerialName("vote_average")
    val rating: Float?,

    @SerialName("poster_path")
    val image: String?,

    @SerialName("first_air_date")
    val date: String?,
    /*
    @SerialName("origin_country")
    val origin_country: List<OriginCountry>?
) : java.io.Serializable {

}

     */
)
*/

@Parcelize
data class Food1(
    val name: String? = "",
    val calories: Double?
) : Parcelable