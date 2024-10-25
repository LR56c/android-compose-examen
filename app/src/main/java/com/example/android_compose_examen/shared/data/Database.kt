package com.example.android_compose_examen.shared.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.android_compose_examen.measure.data.MeasureDao
import com.example.android_compose_examen.measure.data.MeasureEntity

@Database(entities = [MeasureEntity::class], version = 1)
@TypeConverters(LocalDateConverter::class)
abstract class Database : RoomDatabase() {
		abstract fun measureDao(): MeasureDao
}
