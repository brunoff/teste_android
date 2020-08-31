package br.com.bruno.fonseca.app

import android.app.Application
import br.com.bruno.fonseca.app.sl.networkModule
import br.com.bruno.fonseca.app.sl.repositoryModules
import br.com.bruno.fonseca.app.sl.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

open class App : Application() {

    private val appModules by lazy {
        listOf(networkModule, repositoryModules, viewModelModule)
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModules)
        }
    }
}