package com.example.app.presentation.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.app.ui.theme.Blue

@Composable
fun BottomNavigation(navController: NavController){

    val items = listOf<BottomNavItem>(
        BottomNavItem.PutNfc,
        BottomNavItem.CardList,
        BottomNavItem.Profile
    )

    androidx.compose.material.BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Blue.DeepBlue
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            val selected = currentRoute == item.route
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier
                            .width(26.dp)
                            .height(26.dp)
                    )
                },
                label = {
                    if(selected) Text( item.title, fontSize = 9.sp, color = Blue.DeepBlue)
                    else Text( item.title, fontSize = 9.sp, color = Blue.Blue100)
                     },
                selectedContentColor = Blue.DeepBlue,
                unselectedContentColor = Blue.Blue100,
                selected = selected,
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }

    }

}
