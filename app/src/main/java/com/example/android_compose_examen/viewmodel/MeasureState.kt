package com.example.android_compose_examen.viewmodel

import com.example.android_compose_examen.models.MeasureType
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import java.time.LocalDate
import java.time.LocalDateTime

data class MeasureState(
	val measures: PersistentList<MeasureUI> = persistentListOf(MeasureUI(
		type = MeasureType.WATER,
		price = 1000,
		createdAt = LocalDateTime.now()
	),
		MeasureUI(
			type = MeasureType.GAS,
			price = 200,
			createdAt = LocalDateTime.now()
		),)
) {
}
