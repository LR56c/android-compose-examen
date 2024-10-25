package com.example.android_compose_examen.shared.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_compose_examen.measure.presentation.screens.MeasureFormScreen
import com.example.android_compose_examen.measure.presentation.screens.MeasureHomeScreen
import com.example.android_compose_examen.measure.presentation.viewmodel.MeasureViewModel
import org.koin.androidx.compose.koinViewModel

@Preview(showSystemUi = true)
@Composable
fun NavegationApp(
	navController: NavHostController = rememberNavController(),
	measureViewModel: MeasureViewModel = koinViewModel()
) {
	val state by measureViewModel.state.collectAsStateWithLifecycle()
	NavHost(
		navController = navController,
		startDestination = "home"
	) {
		composable("home") {
			MeasureHomeScreen(
				state = state,
				onNavigateToMeasureForm = {
					navController.navigate("measure")
				}
			)
		}
		composable("measure") {
			MeasureFormScreen(
				onAction = measureViewModel::onAction,
				onBackButtonClicked = {
					navController.popBackStack()
				}
			)
		}
	}
}
