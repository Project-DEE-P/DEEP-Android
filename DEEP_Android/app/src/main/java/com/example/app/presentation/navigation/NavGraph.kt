package com.example.app.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.app.MainScreenView
import com.example.app.MainViewModel
import com.example.app.presentation.screen.card.CardScreen
import com.example.app.presentation.screen.cardlist.CardListScreen
import com.example.app.presentation.screen.create.CreateScreen
import com.example.app.presentation.screen.login.LoginScreen
import com.example.app.presentation.screen.login.LoginViewModel
import com.example.app.presentation.screen.profile.ProfileScreen
import com.example.app.presentation.screen.putnfc.PutNfcScreen
import com.example.app.presentation.screen.signup.SignupScreen
import com.example.app.presentation.screen.start.StartScreen
import com.example.app.presentation.screen.start.StartViewModel

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun NavGraph(
    navController : NavHostController,
    mainViewModel: MainViewModel,
    alert: (@Composable () -> Unit) -> Unit
){
    NavHost(
        navController = navController,
        startDestination = Screen.Start.route
    ){
        composable(route = Screen.Start.route) {
            StartScreen(navController = navController)
        }
        composable(route = Screen.Login.route){
            LoginScreen(navController = navController)
        }
        composable(route = Screen.Signup.route){
            SignupScreen(navController = navController)
        }
        composable(route = Screen.CardList.route){
            CardListScreen(navController = navController)
        }
        composable(route = Screen.Card.route){
            CardScreen(navController = navController)
        }
        composable(route = Screen.Create.route){
            CreateScreen(navController = navController)
        }
        composable(route = Screen.Profile.route){
            ProfileScreen(navController = navController)
        }
        composable(route = Screen.PutNfc.route){
            PutNfcScreen(navController = navController, mainViewModel = mainViewModel, alert = alert)
        }

    }
}