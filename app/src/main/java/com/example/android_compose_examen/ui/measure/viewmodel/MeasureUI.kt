package com.example.android_compose_examen.ui.measure.viewmodel

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.android_compose_examen.modules.measure.domain.Measure
import com.example.android_compose_examen.modules.measure.domain.MeasureType
import com.example.android_compose_examen.ui.measure.utils.toIntDrawableResource
import com.example.android_compose_examen.ui.measure.utils.toIntStringResource
import java.time.LocalDate

data class MeasureUI(
	val id: String,
	val type: MeasureType,
	@StringRes val typeRes: Int,
	@DrawableRes val iconRes : Int,
	val price : Int,
	val createdAt : LocalDate
) {}

fun Measure.toMeasureUI(): MeasureUI {
	return MeasureUI(
		id = id,
		type = type,
		typeRes = type.toIntStringResource(),
		iconRes = type.toIntDrawableResource(),
		price = price,
		createdAt = createdAt
	)
}


