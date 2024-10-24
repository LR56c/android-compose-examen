package com.example.android_compose_examen.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_compose_examen.screens.MeasureFormScreen
import com.example.android_compose_examen.screens.MeasureHomeScreen
import com.example.android_compose_examen.viewmodel.MeasureViewModel

@Preview(showSystemUi = true)
@Composable
fun NavegationApp(
	navController: NavHostController = rememberNavController(),
	measureViewModel: MeasureViewModel = MeasureViewModel()
) {
	val state by measureViewModel.state.collectAsStateWithLifecycle()
	NavHost(
		navController = navController,
		startDestination = "home"
	) {
		composable("home") {
			MeasureHomeScreen(
				state = state,
				onAction = measureViewModel::onAction,
				onNavigateToMeasureForm = {
					navController.navigate("measure")
				}
			)
		}
		composable("measure") {
			MeasureFormScreen(
				state = state,
				onAction = measureViewModel::onAction,
				onBackButtonClicked = {
					navController.popBackStack()
				}
			)
		}
	}
}
