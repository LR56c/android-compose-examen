package com.example.android_compose_examen.measure.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_compose_examen.measure.data.MeasureDao
import com.example.android_compose_examen.measure.data.MeasureEntity
import com.example.android_compose_examen.measure.data.toMeasure
import com.example.android_compose_examen.measure.domain.Measure
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MeasureViewModel(private val dao: MeasureDao) : ViewModel() {
	private val _state = MutableStateFlow(MeasureState())
	val state: StateFlow<MeasureState> = _state.asStateFlow()

	init {
		viewModelScope.launch(Dispatchers.IO) {
			val measures = dao.getAll().map { it.toMeasure().toMeasureUI() }.toPersistentList()
			withContext(Dispatchers.Main) {
				_state.value = _state.value.copy(measures = measures)
			}
		}
	}

	fun addMeasure(measure: Measure) {
		viewModelScope.launch(Dispatchers.IO) {
			dao.create(MeasureEntity(
				id = measure.id,
				type = measure.type,
				price = measure.price,
				createdAt = measure.createdAt
			))
			withContext(Dispatchers.Main) {
				_state.value = _state.value.copy(
					measures = _state.value.measures.add(measure.toMeasureUI())
				)
			}
		}
	}

	fun onAction(action: MeasureAction) {
		when (action) {
			is MeasureAction.AddMeasure -> addMeasure(action.measure)
		}
	}
}
