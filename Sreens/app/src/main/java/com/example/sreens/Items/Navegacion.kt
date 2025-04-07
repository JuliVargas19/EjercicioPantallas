package com.example.sreens.Items

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation() {
    val navController = rememberNavController()
    val userList = remember { mutableStateListOf<Triple<String, String, String>>() }

    NavHost(navController = navController, startDestination = "screenA") {
        composable("screenA") {
            ScreenA(navController, userList)
        }
        composable("screenB") {
            ScreenB(navController, userList)
        }
    }
}