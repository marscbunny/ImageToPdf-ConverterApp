package com.example.imagetopdf_app.presentation.nvgaph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.imagetopdf_app.presentation.AddPdfScreen
import com.example.imagetopdf_app.presentation.PdfScreen
import com.example.imagetopdf_app.presentation.PdfViewModel


@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: Route = Route.PdfScreen
) {

    val viewModel = viewModel<PdfViewModel>()


    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable<Route.PdfScreen> {
            PdfScreen(
                onClick = {
                    navController.navigate(Route.AddPdfScreen)
                },
                viewModel = viewModel
            )
        }

        composable<Route.AddPdfScreen> {
            AddPdfScreen(
                viewModel = viewModel,
                onSelected = viewModel::onEvent,
                onCovertClick = {
                    viewModel.onEvent(it)
                    navController.popBackStack()
                }
            )
        }

    }


}