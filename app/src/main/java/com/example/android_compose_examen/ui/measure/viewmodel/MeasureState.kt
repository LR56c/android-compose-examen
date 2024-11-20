package com.example.android_compose_examen.ui.measure.viewmodel

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class MeasureState(
	val measures: PersistentList<MeasureUI> = persistentListOf()
) {}
