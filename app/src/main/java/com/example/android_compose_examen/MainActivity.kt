package com.example.android_compose_examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.android_compose_examen.navigation.NavegationApp
import com.example.android_compose_examen.ui.theme.AndroidcomposeexamenTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			AndroidcomposeexamenTheme {
					NavegationApp()
			}
		}
	}
}
