package uz.test.kattabozor.data.model.response


import com.google.gson.annotations.SerializedName


data class Image(
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)