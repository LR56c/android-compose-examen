package com.example.android_compose_examen.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.android_compose_examen.viewmodel.MeasureAction
import com.example.android_compose_examen.viewmodel.MeasureState

@Composable
fun MeasureFormScreen(
	state : MeasureState,
	onAction : (MeasureAction) -> Unit,
	modifier: Modifier = Modifier, onBackButtonClicked: () -> Boolean
) {
	Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
	Text(text = "Measure Form", modifier = modifier.padding(innerPadding))
	}
}
