package br.com.dio.app.repositories

import android.app.Application
import br.com.dio.app.repositories.data.di.DataModule
import br.com.dio.app.repositories.domain.di.DomainModule
import br.com.dio.app.repositories.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

//App class
class App : Application() {

    //onCreate app
    override fun onCreate() {
        super.onCreate()

        //Default configuration of Koin
        startKoin {
            androidContext(this@App)
        }

        //Loading all in DataModule, DomainModule and PresentationModule w/Koin dependency injection
        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}