package com.example.app.presentation.navigation

import com.example.deep_android.R

sealed class Screen(val route : String) {
    object Card : Screen("card_screen")
    object CardList : Screen("card_list_screen")
    object Create : Screen("create_screen")
    object Profile : Screen("profile_screen")
}

sealed class BottomNavItem(val title : String, val icon : Int, val route : String) {
    object Create : BottomNavItem("명함 등록", R.drawable.ic_create,"create_screen")
    object CardList : BottomNavItem("보관함", R.drawable.ic_list,"card_list_screen")
    object Profile : BottomNavItem("프로필", R.drawable.ic_profile,"profile_screen")
}
