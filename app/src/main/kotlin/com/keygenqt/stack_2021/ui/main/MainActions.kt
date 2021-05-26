package com.keygenqt.stack_2021.ui.main

import androidx.navigation.NavHostController

class MainActions(navController: NavHostController) {
    val navigateToDetailsRepo: (Long) -> Unit = { id: Long ->
        NavScreen.DetailsRepo.apply {
            navController.navigate(routeWithArgument.replace("{$argument0}", id.toString()))
        }
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}