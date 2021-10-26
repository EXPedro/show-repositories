package br.com.dio.app.repositories.data.di

import android.util.Log
import br.com.dio.app.repositories.data.repositories.RepoRepository
import br.com.dio.app.repositories.data.repositories.RepoRepositoryImpl
import br.com.dio.app.repositories.data.services.GitHubService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Koin object with Dependency Injection
object DataModule {
    private const val OK_HTTP = "OkHttp"

    //Using Koin in 'load' method, w/network and repositories modules
    fun load() {
        loadKoinModules(networkModules() + repositoriesModule())
    }

    //Provides a module w/http configuration, json converter and githubService
    private fun networkModules(): Module {
        return module {
            single {
                val interceptor = HttpLoggingInterceptor {
                    Log.e(OK_HTTP, it)
                }
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()
            }
            single {
                GsonConverterFactory.create(GsonBuilder().create())
            }
            single {
                createService<GitHubService>(get(), get())
            }
        }
    }

    //Module to list all repositories
    private fun repositoriesModule(): Module {
        return module {
            single<RepoRepository> { RepoRepositoryImpl(get()) }
        }
    }

    //Retrofit class generates an implementation of the gitHubService interface
    private inline fun <reified T> createService(client: OkHttpClient, factory: GsonConverterFactory): T {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(client)
            .addConverterFactory(factory)
            .build().create(T::class.java)
    }
}