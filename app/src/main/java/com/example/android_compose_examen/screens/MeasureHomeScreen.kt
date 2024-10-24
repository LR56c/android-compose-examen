package com.example.android_compose_examen.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.android_compose_examen.components.MeasureItem
import com.example.android_compose_examen.viewmodel.MeasureAction
import com.example.android_compose_examen.viewmodel.MeasureState

@Composable
fun MeasureHomeScreen(
	state : MeasureState,
	onAction : (MeasureAction) -> Unit,
	modifier: Modifier = Modifier, onNavigateToMeasureForm: () -> Unit
) {
	Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
		LazyColumn(
			modifier = modifier.padding(innerPadding).fillMaxSize(),
			verticalArrangement = Arrangement.spacedBy(8.dp)
		) {
			items(state.measures) { measure ->
				MeasureItem(measure = measure)
				Spacer(modifier = Modifier.height(8.dp))
				HorizontalDivider(
					thickness = 1.dp,
					color = Color.Gray
				)
			}
		}
	}
}
