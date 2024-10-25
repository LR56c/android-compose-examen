package com.example.android_compose_examen.measure.data

import com.example.android_compose_examen.measure.domain.Measure

fun MeasureEntity.toMeasure(): Measure {
		return Measure(
				id = id,
				type = type,
				price = price,
				createdAt = createdAt
		)
}
