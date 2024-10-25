package com.example.android_compose_examen.measure.presentation.viewmodel

import com.example.android_compose_examen.measure.domain.Measure

sealed interface MeasureAction {
	data class AddMeasure(val measure: Measure) : MeasureAction
}
