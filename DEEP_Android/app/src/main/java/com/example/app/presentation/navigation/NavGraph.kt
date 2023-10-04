package com.example.app.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.app.MainViewModel
import com.example.app.presentation.screen.card.CardScreen
import com.example.app.presentation.screen.cardlist.CardListScreen
import com.example.app.presentation.screen.create.CreateScreen
import com.example.app.presentation.screen.profile.ProfileScreen

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun NavGraph(
    navController : NavHostController,
    mainViewModel: MainViewModel,
    alert: (@Composable () -> Unit) -> Unit
){
    NavHost(
        navController = navController,
        startDestination = Screen.CardList.route
    ){
        composable(route = Screen.CardList.route){
            CardListScreen(navController = navController)
        }
        composable(route = Screen.Card.route){
            CardScreen(navController = navController)
        }
        composable(route = Screen.Create.route){
            CreateScreen(navController = navController, mainViewModel = mainViewModel, alert = alert)
        }
        composable(route = Screen.Profile.route){
            ProfileScreen(navController = navController)
        }

    }
}