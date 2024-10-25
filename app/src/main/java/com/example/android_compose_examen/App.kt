package com.example.android_compose_examen
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import android.app.Application
import com.example.android_compose_examen.di.appModule

class App : Application() {
	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidContext(this@App)
			androidLogger()
			modules(appModule(this@App))
		}
	}
}
