package com.example.android_compose_examen.modules.measure.domain
import ulid.ULID
import java.time.LocalDate

data class Measure(
	val id: String = ULID.randomULID(),
	val type: MeasureType,
	val price : Int,
	val createdAt : LocalDate
) {}


