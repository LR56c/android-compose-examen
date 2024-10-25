package com.example.android_compose_examen.measure.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MeasureDao {
	@Query("SELECT * FROM measures")
	suspend fun getAll() : List<MeasureEntity>

	@Query("SELECT * FROM measures WHERE id = :id")
	suspend fun getById(id: String) : MeasureEntity

	@Delete
	suspend fun delete(measure: MeasureEntity)

	@Insert
	suspend fun create(measure: MeasureEntity)

	@Update
	suspend fun update(measure: MeasureEntity)
}
