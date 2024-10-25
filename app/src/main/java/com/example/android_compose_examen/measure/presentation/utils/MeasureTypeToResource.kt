package com.example.android_compose_examen.measure.presentation.utils
import com.example.android_compose_examen.measure.domain.MeasureType
import com.example.android_compose_examen.R

fun MeasureType.toIntStringResource() = when (this) {
		MeasureType.WATER -> R.string.water
		MeasureType.LIGHT -> R.string.light
		MeasureType.GAS -> R.string.gas
	}


fun MeasureType.toIntDrawableResource() : Int = when (this) {
	MeasureType.WATER -> R.drawable.water
	MeasureType.LIGHT -> R.drawable.light
	MeasureType.GAS -> R.drawable.gas
}
