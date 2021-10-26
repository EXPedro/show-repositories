package br.com.dio.app.repositories.data.services

import br.com.dio.app.repositories.data.model.Repo
import retrofit2.http.GET
import retrofit2.http.Path

//Interface that implements retrofit getAll method according w/criteria search 'user'
interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun listRepositories(@Path("user") user: String) : List<Repo>
}