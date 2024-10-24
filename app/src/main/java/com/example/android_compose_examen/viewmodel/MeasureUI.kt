package com.example.android_compose_examen.viewmodel

import com.example.android_compose_examen.models.MeasureType
import ulid.ULID
import java.time.LocalDateTime

data class MeasureUI(
	val id: String = ULID.randomULID(),
	val type: MeasureType,
	val price : Int,
	val createdAt : LocalDateTime
) {}
