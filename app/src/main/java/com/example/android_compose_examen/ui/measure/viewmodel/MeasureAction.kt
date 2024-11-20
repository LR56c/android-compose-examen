package com.example.android_compose_examen.ui.measure.viewmodel

import com.example.android_compose_examen.modules.measure.domain.Measure


sealed interface MeasureAction {
	data class AddMeasure(val measure: Measure) : MeasureAction
}
