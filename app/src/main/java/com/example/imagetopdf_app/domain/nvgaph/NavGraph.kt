package com.example.imagetopdf_app.domain.nvgaph

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.imagetopdf_app.presentation.PdfScreen


@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: Route
){


    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable<Route.PdfScreen> {
            PdfScreen()
        }

    }



}