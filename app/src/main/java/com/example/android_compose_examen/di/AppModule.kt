package com.example.android_compose_examen.di
import android.app.Application
import androidx.room.Room
import com.example.android_compose_examen.configuration.data.Database
import org.koin.dsl.module
import com.example.android_compose_examen.ui.measure.viewmodel.MeasureViewModel
import org.koin.core.module.dsl.viewModelOf

fun appModule(application: Application) = module {
	single { Room.databaseBuilder(application, Database::class.java, "measure").build() }
	single { get<Database>().measureDao() }
	viewModelOf(::MeasureViewModel)
}


