package br.com.dio.app.repositories.data.repositories

import br.com.dio.app.repositories.core.RemoteException
import br.com.dio.app.repositories.data.services.GitHubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

//Class that implements Repo interface, listing all the repositories
class RepoRepositoryImpl(private val service: GitHubService) : RepoRepository {

    //Method to list repositories, implementation of the interface
    override suspend fun listRepositories(user: String) = flow {
        try {
            val repoList = service.listRepositories(user)
            emit(repoList)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "Não foi possivel fazer a busca no momento!")
        }
    }
}