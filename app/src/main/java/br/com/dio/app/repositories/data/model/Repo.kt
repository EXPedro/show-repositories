package br.com.dio.app.repositories.data.model

import com.google.gson.annotations.SerializedName

//Class created w/Repo model in https://app.quicktype.io/
data class Repo(
    val id: Long,
    val name: String,
    val owner: Owner,

    //underlined
    @SerializedName("stargazers_count")
    val stargazersCount: Long,
    val language: String,

    //underlined
    @SerializedName("html_url")
    val htmlURL: String,
    val description: String
)
