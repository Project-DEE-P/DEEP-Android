package com.example.app.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.app.MainViewModel
import com.example.app.di.HiltApplication
import com.example.app.presentation.screen.card.CardScreen
import com.example.app.presentation.screen.carddetail.CardDetailScreen
import com.example.app.presentation.screen.cardlist.CardListScreen
import com.example.app.presentation.screen.create.CreateScreen
import com.example.app.presentation.screen.login.screen.LoginScreen
import com.example.app.presentation.screen.profile.ProfileScreen
import com.example.app.presentation.screen.putnfc.PutNfcScreen
import com.example.app.presentation.screen.signup.screen.SignupScreen
import com.example.app.presentation.screen.start.screen.StartScreen

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun NavGraph(
    navController : NavHostController,
    mainViewModel: MainViewModel,
    alert: (@Composable () -> Unit) -> Unit
){
    NavHost(
        navController = navController,
        startDestination = if (HiltApplication.pref.autoLogin) Screen.PutNfc.route else Screen.Start.route
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
            CardListScreen(navController = navController, mainViewModel = mainViewModel)
        }
        composable(route = Screen.Card.route){
            CardScreen(navController = navController)
        }
        composable(route = Screen.Create.route){
            CreateScreen(navController = navController, mainViewModel = mainViewModel)
        }
        composable(route = Screen.Profile.route){
            ProfileScreen(navController = navController)
        }
        composable(route = Screen.PutNfc.route){
            PutNfcScreen(navController = navController, mainViewModel = mainViewModel, alert = alert)
        }
        composable(route = Screen.CardDetail.route){
            CardDetailScreen(mainViewModel = mainViewModel)
        }
    }
}