package com.example.imagetopdf_app

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.imagetopdf_app.domain.nvgaph.NavGraph
import com.example.imagetopdf_app.domain.nvgaph.Route
import com.example.imagetopdf_app.ui.theme.ImageToPdfAppTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
            ImageToPdfAppTheme {
                val navController = rememberNavController()
                NavGraph(
                    startDestination = Route.PdfScreen,
                    navController = navController
                )
            }
        }
    }
}