package com.NguyenBower.hc

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Preview
@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.MainScreen.route){
        composable(route = Screens.MainScreen.route){
            MainScreen().MainScreen(navController)
        }
        composable(route = Screens.ListScreen.route){
            RetreiveData().ListScreen(navController)
        }
        composable(route= Screens.InfoScreen.route + "?id={id}", arguments = listOf(
            navArgument("id"){
                type = NavType.StringType
                nullable = true
            }
        )){hospitalInfo ->
            Info().infoScreen(hospitalInfo.id)
        }
    }
}