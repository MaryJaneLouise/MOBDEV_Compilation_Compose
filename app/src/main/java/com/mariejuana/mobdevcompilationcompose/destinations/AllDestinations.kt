package com.mariejuana.mobdevcompilationcompose.destinations

import androidx.navigation.NavHostController

object AllDestinations {
    const val HOME = "Home"

    //BASICS
    const val PRINT_NAME = "Print Name"
    const val ODD_OR_EVEN = "Odd or Even"
    const val ANDROID_STATUS = "Android Status"
    const val MINI_CALCULATOR = "Mini Calculator"

    //LECTURES
    const val LM1 = "LM1"
    const val LM2 = "LM2"

    //ACTIVITIES
    const val THE_STRUGGLE = "The Struggle"
    const val RANDOM_QUOTES = "Random Quotes"
}

class AppNavigationActions(private val navController: NavHostController) {
    fun navigateToHome() {
        navController.navigate(AllDestinations.HOME) {
            popUpTo(AllDestinations.HOME)
        }
    }

    fun navigateToPrintName() {
        navController.navigate(AllDestinations.PRINT_NAME) {
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToOddOrEven() {
        navController.navigate(AllDestinations.ODD_OR_EVEN) {
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToAndroidStatus() {
        navController.navigate(AllDestinations.ANDROID_STATUS) {
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToMiniCalculator() {
        navController.navigate(AllDestinations.MINI_CALCULATOR) {
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToLM1() {
        navController.navigate(AllDestinations.LM1) {
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToLM2() {
        navController.navigate(AllDestinations.LM2) {
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToTheStruggle() {
        navController.navigate(AllDestinations.THE_STRUGGLE) {
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToRandomQuotes() {
        navController.navigate(AllDestinations.RANDOM_QUOTES) {
            launchSingleTop = true
            restoreState = true
        }
    }
}
