package com.example.android_compose_examen.viewmodel

sealed interface MeasureAction {
	data class AddMeasure(val measure: MeasureUI) : MeasureAction
}
