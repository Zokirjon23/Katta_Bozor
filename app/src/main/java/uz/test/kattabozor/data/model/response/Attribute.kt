package uz.test.kattabozor.data.model.response


import com.google.gson.annotations.SerializedName

data class Attribute(
    @SerializedName("name")
    val name: String,
    @SerializedName("value")
    val value: String
)