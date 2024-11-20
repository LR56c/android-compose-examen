package com.example.android_compose_examen.ui.measure.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_compose_examen.modules.measure.domain.Measure
import com.example.android_compose_examen.modules.measure.domain.MeasureType
import com.example.android_compose_examen.ui.measure.utils.toIntStringResource
import com.example.android_compose_examen.ui.measure.viewmodel.MeasureAction
import java.time.LocalDate
import kotlin.collections.get

@Composable
fun MeasureFormScreen(
	onAction: (MeasureAction) -> Unit,
	modifier: Modifier = Modifier,
	onBackButtonClicked: () -> Boolean
) {
	var measurePrice by remember { mutableStateOf("") }
	var measureDate by remember { mutableStateOf("") }
	val types = MeasureType.entries.toTypedArray()
	var selectedType by remember { mutableStateOf<MeasureType>(types[0]) }

	val configuration = LocalConfiguration.current
	val screenWidth = configuration.screenWidthDp.dp
	val paddingValue = screenWidth * 0.15f

	Scaffold(
		modifier = Modifier.fillMaxSize()
	) { innerPadding ->
		Column(
			modifier = Modifier
				.padding(innerPadding)
				.fillMaxSize(),
			verticalArrangement = Arrangement.spacedBy(32.dp),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Text(
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold,
				text = "Registro Medidor"
			)
			TextField(value = measurePrice,
				onValueChange = { measurePrice = it },
				label = { Text("Precio") })
			TextField(value = measureDate,
				onValueChange = { measureDate = it },
				label = { Text("Fecha") })
			Column(
				modifier = Modifier
					.selectableGroup()
					.align(Alignment.Start)
					.padding(horizontal = paddingValue)
			) {
				Text(text = "Medidor de:")
				types.forEach { type ->
					Row(
						verticalAlignment = Alignment.CenterVertically
					) {
						RadioButton(
							selected = selectedType == type,
							onClick = { selectedType = type },
						)
						Text(stringResource(type.toIntStringResource()))
					}
				}
			}
			Button(onClick = {
				onAction(
					MeasureAction.AddMeasure(Measure(
							price = measurePrice.toInt(),
							createdAt = LocalDate.parse(measureDate),
							type = selectedType
						))
				)
				onBackButtonClicked()
			}) {
				Text("Registar medicion")
			}
		}
	}
}
