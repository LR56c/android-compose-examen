package com.example.android_compose_examen.di
import android.app.Application
import androidx.room.Room
import org.koin.dsl.module
import com.example.android_compose_examen.measure.presentation.viewmodel.MeasureViewModel
import com.example.android_compose_examen.shared.data.Database
import org.koin.core.module.dsl.viewModelOf

fun appModule(application: Application) = module {
	single { Room.databaseBuilder(application, Database::class.java, "measure").build() }
	single { get<Database>().measureDao() }
	viewModelOf(::MeasureViewModel)
}
