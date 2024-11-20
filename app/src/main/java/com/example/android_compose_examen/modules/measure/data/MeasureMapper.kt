package com.example.android_compose_examen.modules.measure.data

import com.example.android_compose_examen.modules.measure.domain.Measure

fun MeasureEntity.toMeasure(): Measure {
		return Measure(
			id = id, type = type, price = price, createdAt = createdAt
		)
}
