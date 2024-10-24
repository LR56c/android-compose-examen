package com.example.android_compose_examen.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MeasureViewModel() : ViewModel() {
	private val _state = MutableStateFlow(MeasureState())
	val state : StateFlow<MeasureState> = _state.asStateFlow()

	fun addMeasure(measure: MeasureUI) {
		_state.value = _state.value.copy(
			measures = _state.value.measures.add(measure)
		)
	}

	fun onAction(action: MeasureAction) {
		when (action) {
			is MeasureAction.AddMeasure -> addMeasure(action.measure)
		}
	}
}
