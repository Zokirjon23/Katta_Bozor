package uz.test.kattabozor.data.model.response

import com.google.gson.annotations.SerializedName

data class OfferResponse(
    @SerializedName("offers")
    val offers : List<OfferItem>
)