package uz.test.kattabozor.data.model.response


import com.google.gson.annotations.SerializedName

data class OfferItem(
    @SerializedName("attributes")
    val attributes: List<Attribute>,
    @SerializedName("brand")
    val brand: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: Image,
    @SerializedName("merchant")
    val merchant: String,
    @SerializedName("name")
    val name: String
)