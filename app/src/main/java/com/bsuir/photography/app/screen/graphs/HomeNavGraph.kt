package com.bsuir.photography.app.screen.graphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bsuir.photography.Singletons
import com.bsuir.photography.app.screen.screens.*

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Screen.Home.route,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable (route = BottomBarScreen.Home.route) {
            PhotographyContent()
        }
        composable(route = BottomBarScreen.Profile.route) {
            HomeContext(navController = navController)
        }
        composable(
            route = Screen.DetailId.route,
            arguments = listOf(
                navArgument("id"){
                    type = NavType.StringType
                })
        ){
            val viewModel = Singletons.appViewModel
            val w = viewModel.w.observeAsState()
            LaunchedEffect(Unit) {
                viewModel.getData(it.arguments?.getString("id").toString())
            }

            w.value?.let { it1 -> DetailScreen(it1) }
        }
    }
}

