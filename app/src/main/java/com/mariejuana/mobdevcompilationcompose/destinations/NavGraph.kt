package com.mariejuana.mobdevcompilationcompose.destinations

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mariejuana.mobdevcompilationcompose.ui.screens.AppDrawer
import com.mariejuana.mobdevcompilationcompose.ui.screens.activities.minigame1.TheStruggleScreen
import com.mariejuana.mobdevcompilationcompose.ui.screens.activities.randomquotes.RandomQuoteScreen
import com.mariejuana.mobdevcompilationcompose.ui.screens.basics.android_status.AndroidStatusScreen
import com.mariejuana.mobdevcompilationcompose.ui.screens.basics.mini_calculator.MiniCalculatorScreen
import com.mariejuana.mobdevcompilationcompose.ui.screens.home.HomeScreen
import com.mariejuana.mobdevcompilationcompose.ui.screens.basics.odd_or_even.OddOrEvenScreen
import com.mariejuana.mobdevcompilationcompose.ui.screens.basics.print_name.PrintNameScreen
import com.mariejuana.mobdevcompilationcompose.ui.screens.lectures.LM1Screen
import com.mariejuana.mobdevcompilationcompose.ui.screens.lectures.LM2Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {

    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: AllDestinations.HOME
    val navigationActions = remember(navController) {
        AppNavigationActions(navController)
    }

    ModalNavigationDrawer(drawerContent = {
        AppDrawer(
            route = currentRoute,
            navigateToHome = { navigationActions.navigateToHome() },

            navigateToOddOrEven = { navigationActions.navigateToOddOrEven() },
            navigateToPrintName = { navigationActions.navigateToPrintName() },
            navigateToAndroidStatus = { navigationActions.navigateToAndroidStatus() },
            navigateToMiniCalculator = { navigationActions.navigateToMiniCalculator() },

            navigateToTheStruggle = { navigationActions.navigateToTheStruggle() },
            navigateToRandomQuotes = { navigationActions.navigateToRandomQuotes() },

            navigateToLM1 = { navigationActions.navigateToLM1() },
            navigateToLM2 = { navigationActions.navigateToLM2() },

            closeDrawer = { coroutineScope.launch { drawerState.close() } },
            modifier = Modifier
        )
    }, drawerState = drawerState) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = currentRoute) },
                    modifier = Modifier.fillMaxWidth(),
                    navigationIcon = { IconButton(onClick = {
                        coroutineScope.launch { drawerState.open() }
                    },
                        content = {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = null
                        )
                    })
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer))
            }, modifier = Modifier
        ) {
            NavHost(
                navController = navController,
                startDestination = AllDestinations.HOME,
                modifier = modifier.padding(it)
            ) {
                composable(AllDestinations.HOME) {
                    HomeScreen()
                }

                //Basic Bullshite
                composable(AllDestinations.ODD_OR_EVEN) {
                    OddOrEvenScreen()
                }
                composable(AllDestinations.PRINT_NAME) {
                    PrintNameScreen()
                }
                composable(AllDestinations.ANDROID_STATUS) {
                    AndroidStatusScreen()
                }
                composable(AllDestinations.MINI_CALCULATOR) {
                    MiniCalculatorScreen()
                }

                //Lectures
                composable(AllDestinations.LM1) {
                    LM1Screen()
                }
                composable(AllDestinations.LM2) {
                    LM2Screen()
                }

                //Activities
                composable(AllDestinations.THE_STRUGGLE) {
                    TheStruggleScreen()
                }
                composable(AllDestinations.RANDOM_QUOTES) {
                    RandomQuoteScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun NavGraphPreview() {
    NavGraph()
}