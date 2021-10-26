package br.com.dio.app.repositories.data.model

import com.google.gson.annotations.SerializedName

//Class created w/Owner model in https://app.quicktype.io/
data class Owner(
    val login: String,

    //Underline
    @SerializedName("avatar_url")
    val avatarURL: String
)
