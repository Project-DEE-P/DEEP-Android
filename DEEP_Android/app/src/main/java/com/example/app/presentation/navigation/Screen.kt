package com.example.app.presentation.navigation

import com.example.deep_android.R

sealed class Screen(val route : String) {
    object Start: Screen("start_screen")
    object Login: Screen("login_screen")
    object Signup: Screen("signup_screen")
    object Card : Screen("card_screen")
    object CardList : Screen("card_list_screen")
    object CardDetail : Screen("card_detail_screen")
    object Create : Screen("create_screen")
    object Profile : Screen("profile_screen")
    object PutNfc : Screen("put_nfc_screen")
    object Setting : Screen("setting_screen")
}

sealed class BottomNavItem(val title : String, val icon : Int, val route : String) {
    object PutNfc : BottomNavItem("명함 등록", R.drawable.ic_create,"put_nfc_screen")
    object CardList : BottomNavItem("보관함", R.drawable.ic_list,"card_list_screen")
    object Profile : BottomNavItem("프로필", R.drawable.ic_profile,"profile_screen")
}
