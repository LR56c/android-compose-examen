package com.example.android_compose_examen.ui.measure.utils
import com.example.android_compose_examen.R
import com.example.android_compose_examen.modules.measure.domain.MeasureType

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




