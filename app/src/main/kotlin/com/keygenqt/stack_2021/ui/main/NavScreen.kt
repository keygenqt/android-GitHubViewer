package com.keygenqt.stack_2021.ui.main

sealed class NavScreen(val route: String) {
    object Splash : NavScreen("Splash")
    object Home : NavScreen("Home")
    object DetailsRepo : NavScreen("DetailsRepo") {
        const val routeWithArgument: String = "DetailsRepo/{repoId}"
        const val argument0: String = "repoId"
    }
}