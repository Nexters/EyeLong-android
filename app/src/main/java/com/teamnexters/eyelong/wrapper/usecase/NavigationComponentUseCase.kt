package com.teamnexters.eyelong.wrapper.usecase

import androidx.navigation.NavController
import androidx.navigation.NavDirections

class NavigationComponentUseCase(private val navController: NavController) {

    fun navigate(directions: NavDirections) {
        navController.navigate(directions)
    }
}
