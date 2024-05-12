package com.bella.foodapp.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.Text
import androidx.navigation.NavController
import com.bella.foodapp.ui.navigation.Screen

@Composable
fun TopAppBarTitle(nav: NavController) {
    val currentRoute = nav.currentDestination?.route
    var title by remember { mutableStateOf("Food App") }

    LaunchedEffect(currentRoute) {
        when (currentRoute) {
            Screen.Home.route -> title = "Home"
            Screen.Profile.route -> title = "Profile"
            Screen.Drink.route -> title = "Drink"
            Screen.DetailFood.route -> title = "Detail Food"
            else -> title = "Food App"
        }
    }

    Text(title)
}