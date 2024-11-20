package com.example.android_compose_examen.modules.measure.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android_compose_examen.modules.measure.domain.MeasureType
import java.time.LocalDate

@Entity(tableName = "measures")
data class MeasureEntity(
	@PrimaryKey()
	val id: String,
	val type: MeasureType,
	val price : Int,
	val createdAt : LocalDate
) {}




