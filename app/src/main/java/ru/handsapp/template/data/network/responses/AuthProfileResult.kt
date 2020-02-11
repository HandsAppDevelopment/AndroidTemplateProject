package ru.handsapp.template.data.network.responses

import com.google.gson.annotations.SerializedName

data class AuthProfileResult(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)