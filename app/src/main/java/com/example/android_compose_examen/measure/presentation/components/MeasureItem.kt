package com.example.android_compose_examen.measure.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.android_compose_examen.measure.presentation.viewmodel.MeasureUI
import java.text.NumberFormat
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun MeasureItem(modifier: Modifier = Modifier, measure: MeasureUI) {
	val dateFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale("es", "CL"))
	val moneyFormatter = NumberFormat.getCurrencyInstance(Locale("es", "CL"))
//	val ulid = ULID.parseULID(measure.id)
//	val localDate = Instant.ofEpochMilli(ulid.timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime()
	Row(
		modifier = modifier
			.fillMaxWidth()
			.padding(horizontal = 32.dp),
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalAlignment = Alignment.CenterVertically
	) {
		Row(
			modifier = Modifier.weight(0.3f),
			verticalAlignment = Alignment.CenterVertically
		) {
			Image(
				painter = painterResource(id = measure.iconRes),
				contentDescription = "Light",
				modifier = Modifier.height(40.dp)
			)
			Text(
				text = stringResource(measure.typeRes).lowercase()
					.replaceFirstChar { it.uppercase() })
		}
		Text(
			modifier = Modifier.weight(0.2f),
			text = moneyFormatter.format(measure.price)
		)
		Text(
			modifier = Modifier.weight(0.4f),
			text = dateFormatter.format(measure.createdAt)
		)
	}
}
