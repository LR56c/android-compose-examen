package com.example.android_compose_examen.models
import java.time.LocalDateTime

data class Measure(
	val id: String,
	val type: MeasureType,
	val price : Int,
	val createdAt : LocalDateTime
) {}
