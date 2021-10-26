package br.com.dio.app.repositories.data.repositories

import br.com.dio.app.repositories.data.model.Repo
import kotlinx.coroutines.flow.Flow

//Interface w/method that lists all the repositories
interface RepoRepository {
    suspend fun listRepositories(user: String): Flow<List<Repo>>
}