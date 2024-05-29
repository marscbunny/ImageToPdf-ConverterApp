package com.example.imagetopdf_app.presentation.nvgaph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.imagetopdf_app.presentation.PdfScreen
import com.example.imagetopdf_app.presentation.PdfScreenViewModel


@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: Route = Route.PdfScreen
){

    val viewModel = viewModel<PdfScreenViewModel>()


    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable<Route.PdfScreen> {
          PdfScreen(
              viewModel = viewModel,
              onSelected = viewModel::onEvent,
              onCovertClick = viewModel::onEvent
          )
        }

    }



}